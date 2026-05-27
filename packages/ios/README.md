# Design System iOS — White Lotus

Swift Package com o botao e design tokens do White Lotus Design System para iOS/SwiftUI.

## Requisitos

- iOS 15+ / macOS 12+
- Xcode 15+
- Swift 5.9+

## Instalacao

### Swift Package Manager

```swift
// Package.swift
dependencies: [
    .package(path: "../packages/ios")
    // ou remoto:
    // .package(url: "https://github.com/LouizeB/design-system.git", from: "0.1.0")
]
```

```swift
import DesignSystem
```

## Arquitetura de Tokens (3 camadas)

Espelha a mesma arquitetura do design system web:

### Camada 1 — Primitivos (`DSColorPrimitive`)
Valores brutos de cor. Nunca usados diretamente em componentes.

```swift
DSColorPrimitive.Red.shade500    // #E00C2C
DSColorPrimitive.Neutral.shade0  // #FFFFFF
DSSpacing.spacing4               // 16pt
DSRadius.md                      // 8pt
```

### Camada 2 — Semanticos (`DSSemanticColors`)
Tokens que os componentes consomem. Mudam por marca.

```swift
let colors = DSBrand.brandA.colors
colors.actionPrimary           // Red 500 (iFood)
colors.actionPrimaryForeground // White
colors.backgroundDefault       // White (tema claro)
```

### Camada 3 — Component Tokens (`DSButtonToken`)
Tokens especificos do botao (altura, padding, font size por tamanho).

```swift
DSButtonToken.Medium.height    // 40pt
DSButtonToken.Medium.paddingX  // 16pt
DSButtonToken.borderRadius     // 8pt
```

## Componente: DSButton

### Variantes

| Variante | Descricao |
|----------|-----------|
| `primary` | Fundo com cor primaria da marca, texto branco |
| `secondary` | Fundo transparente, borda e texto na cor da marca |
| `ghost` | Fundo transparente, texto na cor de texto primaria |

### Tamanhos

| Tamanho | Altura | Padding X | Font Size |
|---------|--------|-----------|-----------|
| `sm` | 32pt | 12pt | 14pt |
| `md` | 40pt | 16pt | 16pt |
| `lg` | 48pt | 24pt | 18pt |

### Uso Basico

```swift
// Botao primario padrao
DSButton("Confirmar") {
    print("confirmou")
}

// Botao secundario grande
DSButton("Cancelar", variant: .secondary, size: .lg) {
    print("cancelou")
}

// Botao com loading
DSButton("Salvando...", isLoading: true) {
    // bloqueado durante loading
}

// Botao com icones (SF Symbols)
DSButton("Adicionar", leadingIcon: "plus") {
    print("adicionou")
}

// Botao full width
DSButton("Confirmar Pagamento", size: .lg, isFullWidth: true) {
    print("pagou")
}

// Desabilitado
DSButton("Indisponivel") {}
    .disabled(true)
```

### Troca de Marca

```swift
// Via Environment — propaga para toda a hierarquia
VStack {
    DSButton("iFood Style") {}
}
.dsBrand(.brandA)

// Marcas disponiveis:
// .wireframe — Cinza
// .brandA    — iFood (Vermelho)
// .brandB    — POS Verde
// .brandC    — POS Azul
// .brandD    — POS Roxo
```

## Melhores Praticas Aplicadas

- **Design Tokens**: 3 camadas (primitivos, semanticos, componente) espelhando o web
- **Multi-brand**: troca de marca via `@Environment` sem alterar componente
- **SwiftUI nativo**: usa `@Environment`, `ViewModifier`, `PreviewProvider`
- **Acessibilidade**: labels VoiceOver, `accessibilityValue` para estados, `accessibilityHint`
- **Haptic Feedback**: `UIImpactFeedbackGenerator` no tap
- **Animacao**: spring physics no press com `scaleEffect`
- **Dynamic Type**: suporta tamanhos de fonte do sistema
- **Cross-platform**: compila em iOS e macOS (haptics condicionais)
- **Tipagem forte**: enums para variantes/tamanhos, sem magic strings

## Estrutura

```
packages/ios/
├── Package.swift
├── Sources/DesignSystem/
│   ├── DesignSystem.swift          ← Public API
│   ├── Tokens/
│   │   ├── DSColor.swift           ← Primitivos + Semanticos
│   │   ├── DSSpacing.swift         ← Espacamento
│   │   ├── DSRadius.swift          ← Border radius
│   │   ├── DSTypography.swift      ← Tipografia
│   │   ├── DSComponentTokens.swift ← Tokens do botao
│   │   └── DSBrand.swift           ← Marcas + Environment
│   ├── Components/
│   │   └── DSButton.swift          ← Componente Button
│   └── Extensions/
│       └── Color+Hex.swift         ← Helper hex → Color
└── Tests/DesignSystemTests/
    └── DSButtonTests.swift         ← Testes unitarios
```
