import SwiftUI

// MARK: - Brand Definition

public enum DSBrand: String, CaseIterable, Identifiable {
    case wireframe
    case brandA  // iFood
    case brandB  // POS Verde
    case brandC  // POS Azul
    case brandD  // POS Roxo

    public var id: String { rawValue }

    public var displayName: String {
        switch self {
        case .wireframe: return "Wireframe"
        case .brandA:    return "Brand A — iFood"
        case .brandB:    return "Brand B — POS Verde"
        case .brandC:    return "Brand C — POS Azul"
        case .brandD:    return "Brand D — POS Roxo"
        }
    }

    public var colors: DSSemanticColors {
        switch self {
        case .wireframe: return Self.wireframeColors
        case .brandA:    return Self.brandAColors
        case .brandB:    return Self.brandBColors
        case .brandC:    return Self.brandCColors
        case .brandD:    return Self.brandDColors
        }
    }
}

// MARK: - Brand Color Definitions

extension DSBrand {
    private static let wireframeColors = DSSemanticColors(
        actionPrimary:              DSColorPrimitive.Wireframe.shade400,
        actionPrimaryHover:         DSColorPrimitive.Wireframe.shade500,
        actionPrimarySubtle:        DSColorPrimitive.Wireframe.shade100,
        actionPrimaryForeground:    DSColorPrimitive.Neutral.shade0,
        actionSecondaryForeground:  DSColorPrimitive.Wireframe.shade400,
        backgroundDefault:          DSColorPrimitive.Neutral.shade0,
        backgroundSurface:          DSColorPrimitive.Neutral.shade50,
        backgroundHover:            DSColorPrimitive.Neutral.shade100,
        textPrimary:                DSColorPrimitive.Neutral.shade900,
        textSecondary:              DSColorPrimitive.Neutral.shade500,
        textInverse:                DSColorPrimitive.Neutral.shade0,
        borderDefault:              DSColorPrimitive.Neutral.shade200,
        feedbackSuccess:            DSColorPrimitive.Feedback.success,
        feedbackWarning:            DSColorPrimitive.Feedback.warning,
        feedbackError:              DSColorPrimitive.Feedback.error,
        feedbackInfo:               DSColorPrimitive.Feedback.info
    )

    private static let brandAColors = DSSemanticColors(
        actionPrimary:              DSColorPrimitive.Red.shade500,
        actionPrimaryHover:         DSColorPrimitive.Red.shade600,
        actionPrimarySubtle:        DSColorPrimitive.Red.shade50,
        actionPrimaryForeground:    DSColorPrimitive.Neutral.shade0,
        actionSecondaryForeground:  DSColorPrimitive.Red.shade500,
        backgroundDefault:          DSColorPrimitive.Neutral.shade0,
        backgroundSurface:          DSColorPrimitive.Neutral.shade50,
        backgroundHover:            DSColorPrimitive.Neutral.shade100,
        textPrimary:                DSColorPrimitive.Neutral.shade900,
        textSecondary:              DSColorPrimitive.Neutral.shade500,
        textInverse:                DSColorPrimitive.Neutral.shade0,
        borderDefault:              DSColorPrimitive.Neutral.shade200,
        feedbackSuccess:            DSColorPrimitive.Feedback.success,
        feedbackWarning:            DSColorPrimitive.Feedback.warning,
        feedbackError:              DSColorPrimitive.Feedback.error,
        feedbackInfo:               DSColorPrimitive.Feedback.info
    )

    private static let brandBColors = DSSemanticColors(
        actionPrimary:              DSColorPrimitive.Green.shade500,
        actionPrimaryHover:         DSColorPrimitive.Green.shade600,
        actionPrimarySubtle:        DSColorPrimitive.Green.shade50,
        actionPrimaryForeground:    DSColorPrimitive.Neutral.shade0,
        actionSecondaryForeground:  DSColorPrimitive.Green.shade500,
        backgroundDefault:          DSColorPrimitive.Neutral.shade900,
        backgroundSurface:          DSColorPrimitive.Neutral.shade800,
        backgroundHover:            DSColorPrimitive.Neutral.shade700,
        textPrimary:                DSColorPrimitive.Neutral.shade0,
        textSecondary:              DSColorPrimitive.Neutral.shade400,
        textInverse:                DSColorPrimitive.Neutral.shade900,
        borderDefault:              DSColorPrimitive.Neutral.shade700,
        feedbackSuccess:            DSColorPrimitive.Feedback.success,
        feedbackWarning:            DSColorPrimitive.Feedback.warning,
        feedbackError:              DSColorPrimitive.Feedback.error,
        feedbackInfo:               DSColorPrimitive.Feedback.info
    )

    private static let brandCColors = DSSemanticColors(
        actionPrimary:              DSColorPrimitive.Blue.shade500,
        actionPrimaryHover:         DSColorPrimitive.Blue.shade600,
        actionPrimarySubtle:        DSColorPrimitive.Blue.shade50,
        actionPrimaryForeground:    DSColorPrimitive.Neutral.shade0,
        actionSecondaryForeground:  DSColorPrimitive.Blue.shade500,
        backgroundDefault:          DSColorPrimitive.Neutral.shade0,
        backgroundSurface:          DSColorPrimitive.Neutral.shade50,
        backgroundHover:            DSColorPrimitive.Neutral.shade100,
        textPrimary:                DSColorPrimitive.Neutral.shade900,
        textSecondary:              DSColorPrimitive.Neutral.shade500,
        textInverse:                DSColorPrimitive.Neutral.shade0,
        borderDefault:              DSColorPrimitive.Neutral.shade200,
        feedbackSuccess:            DSColorPrimitive.Feedback.success,
        feedbackWarning:            DSColorPrimitive.Feedback.warning,
        feedbackError:              DSColorPrimitive.Feedback.error,
        feedbackInfo:               DSColorPrimitive.Feedback.info
    )

    private static let brandDColors = DSSemanticColors(
        actionPrimary:              DSColorPrimitive.Purple.shade500,
        actionPrimaryHover:         DSColorPrimitive.Purple.shade600,
        actionPrimarySubtle:        DSColorPrimitive.Purple.shade50,
        actionPrimaryForeground:    DSColorPrimitive.Neutral.shade0,
        actionSecondaryForeground:  DSColorPrimitive.Purple.shade500,
        backgroundDefault:          DSColorPrimitive.Neutral.shade900,
        backgroundSurface:          DSColorPrimitive.Neutral.shade800,
        backgroundHover:            DSColorPrimitive.Neutral.shade700,
        textPrimary:                DSColorPrimitive.Neutral.shade0,
        textSecondary:              DSColorPrimitive.Neutral.shade400,
        textInverse:                DSColorPrimitive.Neutral.shade900,
        borderDefault:              DSColorPrimitive.Neutral.shade700,
        feedbackSuccess:            DSColorPrimitive.Feedback.success,
        feedbackWarning:            DSColorPrimitive.Feedback.warning,
        feedbackError:              DSColorPrimitive.Feedback.error,
        feedbackInfo:               DSColorPrimitive.Feedback.info
    )
}

// MARK: - Environment Key for Brand Injection

private struct DSBrandKey: EnvironmentKey {
    static let defaultValue: DSBrand = .brandA
}

extension EnvironmentValues {
    public var dsBrand: DSBrand {
        get { self[DSBrandKey.self] }
        set { self[DSBrandKey.self] = newValue }
    }
}

extension View {
    /// Sets the active brand for this view hierarchy.
    public func dsBrand(_ brand: DSBrand) -> some View {
        environment(\.dsBrand, brand)
    }
}
