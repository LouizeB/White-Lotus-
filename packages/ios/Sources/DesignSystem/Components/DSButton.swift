import SwiftUI

// MARK: - Button Variant & Size

public enum DSButtonVariant: String, CaseIterable {
    case primary
    case secondary
    case ghost
}

public enum DSButtonSize: String, CaseIterable {
    case sm
    case md
    case lg

    var height: CGFloat {
        switch self {
        case .sm: return DSButtonToken.Small.height
        case .md: return DSButtonToken.Medium.height
        case .lg: return DSButtonToken.Large.height
        }
    }

    var paddingX: CGFloat {
        switch self {
        case .sm: return DSButtonToken.Small.paddingX
        case .md: return DSButtonToken.Medium.paddingX
        case .lg: return DSButtonToken.Large.paddingX
        }
    }

    var fontSize: CGFloat {
        switch self {
        case .sm: return DSButtonToken.Small.fontSize
        case .md: return DSButtonToken.Medium.fontSize
        case .lg: return DSButtonToken.Large.fontSize
        }
    }

    var spinnerSize: CGFloat {
        switch self {
        case .sm: return 12
        case .md: return 14
        case .lg: return 16
        }
    }

    var iconSize: CGFloat {
        switch self {
        case .sm: return 14
        case .md: return 16
        case .lg: return 18
        }
    }
}

// MARK: - DSButton

/// A multi-brand button component following Apple HIG and design token architecture.
///
/// Features:
/// - 3 variants: primary, secondary, ghost
/// - 3 sizes: sm, md, lg
/// - Loading state with animated spinner
/// - Leading/trailing icon support (SF Symbols)
/// - Full-width option
/// - Haptic feedback on tap
/// - VoiceOver / Dynamic Type accessible
/// - Spring animation on press
/// - Brand-aware via `@Environment(\.dsBrand)`
///
/// Usage:
/// ```swift
/// DSButton("Confirmar", variant: .primary) {
///     // action
/// }
///
/// DSButton("Salvar", variant: .secondary, size: .lg, isLoading: true) {
///     // action
/// }
/// .dsBrand(.brandB)
/// ```
public struct DSButton: View {
    private let title: String
    private let variant: DSButtonVariant
    private let size: DSButtonSize
    private let isLoading: Bool
    private let isFullWidth: Bool
    private let leadingIcon: String?
    private let trailingIcon: String?
    private let action: () -> Void

    @Environment(\.dsBrand) private var brand
    @Environment(\.isEnabled) private var isEnabled

    @State private var isPressed = false

    public init(
        _ title: String,
        variant: DSButtonVariant = .primary,
        size: DSButtonSize = .md,
        isLoading: Bool = false,
        isFullWidth: Bool = false,
        leadingIcon: String? = nil,
        trailingIcon: String? = nil,
        action: @escaping () -> Void
    ) {
        self.title = title
        self.variant = variant
        self.size = size
        self.isLoading = isLoading
        self.isFullWidth = isFullWidth
        self.leadingIcon = leadingIcon
        self.trailingIcon = trailingIcon
        self.action = action
    }

    public var body: some View {
        Button(action: handleTap) {
            content
        }
        .buttonStyle(.plain)
        .frame(height: size.height)
        .frame(maxWidth: isFullWidth ? .infinity : nil)
        .padding(.horizontal, size.paddingX)
        .background(backgroundColor)
        .foregroundColor(foregroundColor)
        .clipShape(RoundedRectangle(cornerRadius: DSButtonToken.borderRadius))
        .overlay(borderOverlay)
        .opacity(effectiveOpacity)
        .scaleEffect(isPressed ? 0.97 : 1.0)
        .animation(
            .spring(response: DSButtonToken.transitionDuration, dampingFraction: 0.7),
            value: isPressed
        )
        .simultaneousGesture(pressGesture)
        .disabled(!isEnabled || isLoading)
        .accessibilityElement(children: .combine)
        .accessibilityLabel(title)
        .accessibilityAddTraits(.isButton)
        .accessibilityValue(accessibilityStateValue)
        .accessibilityHint(isLoading ? "Aguarde o carregamento" : "")
    }

    // MARK: - Content Layout

    private var content: some View {
        HStack(spacing: DSSpacing.spacing2) {
            if isLoading {
                SpinnerView(size: size.spinnerSize)
            }

            if let leadingIcon, !isLoading {
                Image(systemName: leadingIcon)
                    .font(.system(size: size.iconSize, weight: .medium))
            }

            Text(title)
                .font(.system(size: size.fontSize, weight: DSButtonToken.fontWeight))
                .lineLimit(1)

            if let trailingIcon, !isLoading {
                Image(systemName: trailingIcon)
                    .font(.system(size: size.iconSize, weight: .medium))
            }
        }
    }

    // MARK: - Variant Styling

    private var colors: DSSemanticColors {
        brand.colors
    }

    private var backgroundColor: Color {
        switch variant {
        case .primary:
            return isPressed ? colors.actionPrimaryHover : colors.actionPrimary
        case .secondary:
            return isPressed ? colors.backgroundHover : .clear
        case .ghost:
            return isPressed ? colors.backgroundHover : .clear
        }
    }

    private var foregroundColor: Color {
        switch variant {
        case .primary:   return colors.actionPrimaryForeground
        case .secondary: return colors.actionSecondaryForeground
        case .ghost:     return colors.textPrimary
        }
    }

    @ViewBuilder
    private var borderOverlay: some View {
        if variant == .secondary {
            RoundedRectangle(cornerRadius: DSButtonToken.borderRadius)
                .strokeBorder(colors.actionSecondaryForeground, lineWidth: DSButtonToken.borderWidth)
        }
    }

    private var effectiveOpacity: Double {
        (!isEnabled || isLoading) ? 0.4 : 1.0
    }

    // MARK: - Interaction

    private var pressGesture: some Gesture {
        DragGesture(minimumDistance: 0)
            .onChanged { _ in isPressed = true }
            .onEnded { _ in isPressed = false }
    }

    private func handleTap() {
        guard !isLoading else { return }
        #if os(iOS)
        let generator = UIImpactFeedbackGenerator(style: .light)
        generator.impactOccurred()
        #endif
        action()
    }

    // MARK: - Accessibility

    private var accessibilityStateValue: String {
        if isLoading { return "Carregando" }
        if !isEnabled { return "Desabilitado" }
        return ""
    }
}

// MARK: - Spinner

private struct SpinnerView: View {
    let size: CGFloat
    @State private var isAnimating = false

    var body: some View {
        Circle()
            .trim(from: 0, to: 0.75)
            .stroke(style: StrokeStyle(lineWidth: 2, lineCap: .round))
            .frame(width: size, height: size)
            .rotationEffect(.degrees(isAnimating ? 360 : 0))
            .onAppear {
                withAnimation(
                    .linear(duration: 0.6)
                    .repeatForever(autoreverses: false)
                ) {
                    isAnimating = true
                }
            }
    }
}

// MARK: - Convenience Modifiers

extension DSButton {
    /// Creates a destructive-style button using feedback/error color.
    public static func destructive(
        _ title: String,
        size: DSButtonSize = .md,
        isLoading: Bool = false,
        action: @escaping () -> Void
    ) -> some View {
        DSButton(
            title,
            variant: .primary,
            size: size,
            isLoading: isLoading,
            action: action
        )
        .tint(DSColorPrimitive.Feedback.error)
    }
}

// MARK: - Preview

#if DEBUG
struct DSButton_Previews: PreviewProvider {
    static var previews: some View {
        ScrollView {
            VStack(spacing: DSSpacing.spacing6) {

                // Variants
                sectionHeader("Variantes")
                DSButton("Primary", variant: .primary) {}
                DSButton("Secondary", variant: .secondary) {}
                DSButton("Ghost", variant: .ghost) {}

                // Sizes
                sectionHeader("Tamanhos")
                DSButton("Pequeno", size: .sm) {}
                DSButton("Medio", size: .md) {}
                DSButton("Grande", size: .lg) {}

                // States
                sectionHeader("Estados")
                DSButton("Carregando", isLoading: true) {}
                DSButton("Desabilitado") {}
                    .disabled(true)

                // Icons
                sectionHeader("Com Icones")
                DSButton("Adicionar", leadingIcon: "plus") {}
                DSButton("Proximo", trailingIcon: "arrow.right") {}
                DSButton("Favoritar", leadingIcon: "heart.fill", trailingIcon: "chevron.right") {}

                // Full Width
                sectionHeader("Largura Total")
                DSButton("Confirmar Pagamento", variant: .primary, size: .lg, isFullWidth: true) {}

            }
            .padding(DSSpacing.spacing4)
        }
        .dsBrand(.brandA)
        .previewDisplayName("Brand A — iFood")

        ScrollView {
            VStack(spacing: DSSpacing.spacing6) {
                DSButton("Primary", variant: .primary) {}
                DSButton("Secondary", variant: .secondary) {}
                DSButton("Ghost", variant: .ghost) {}
                DSButton("Carregando", isLoading: true) {}
                DSButton("Full Width", isFullWidth: true) {}
            }
            .padding(DSSpacing.spacing4)
        }
        .dsBrand(.brandB)
        .background(DSColorPrimitive.Neutral.shade900)
        .previewDisplayName("Brand B — POS Verde")

        ScrollView {
            VStack(spacing: DSSpacing.spacing6) {
                DSButton("Primary", variant: .primary) {}
                DSButton("Secondary", variant: .secondary) {}
                DSButton("Ghost", variant: .ghost) {}
            }
            .padding(DSSpacing.spacing4)
        }
        .dsBrand(.brandC)
        .previewDisplayName("Brand C — POS Azul")

        ScrollView {
            VStack(spacing: DSSpacing.spacing6) {
                DSButton("Primary", variant: .primary) {}
                DSButton("Secondary", variant: .secondary) {}
                DSButton("Ghost", variant: .ghost) {}
            }
            .padding(DSSpacing.spacing4)
        }
        .dsBrand(.brandD)
        .background(DSColorPrimitive.Neutral.shade900)
        .previewDisplayName("Brand D — POS Roxo")
    }

    private static func sectionHeader(_ text: String) -> some View {
        Text(text)
            .font(.system(size: DSFontSize.xs, weight: .semibold))
            .foregroundColor(DSColorPrimitive.Neutral.shade500)
            .textCase(.uppercase)
            .frame(maxWidth: .infinity, alignment: .leading)
    }
}
#endif
