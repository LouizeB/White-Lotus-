# @ds/kotlin-ui — Design System for Android (Jetpack Compose)

Android library implementing the White Lotus Design System button component with the same 3-layer token architecture used in the React/CSS counterpart.

## Architecture

```
Primitive tokens          →  ColorPrimitives, SpacingTokens, TypographyTokens, RadiusTokens
  ↓
Semantic tokens (brands)  →  DSColorScheme + brand implementations (BrandA–D, Wireframe)
  ↓
Component tokens          →  ButtonTokens (height, padding, font-size per size)
  ↓
Composable                →  DSButton (reads tokens via DSTheme)
```

## Quick start

```kotlin
// 1. Wrap your app/screen with DSTheme
DSTheme(brand = Brand.BrandA) {
    // 2. Use the button
    DSButton(onClick = { /* action */ }) {
        Text("Confirmar pagamento")
    }
}
```

## DSButton API

| Parameter  | Type              | Default              | Description                                 |
|------------|-------------------|----------------------|---------------------------------------------|
| `onClick`  | `() -> Unit`      | —                    | Click callback                              |
| `modifier` | `Modifier`        | `Modifier`           | Standard Compose modifier                   |
| `variant`  | `DSButtonVariant` | `Primary`            | `Primary`, `Secondary`, `Ghost`             |
| `size`     | `DSButtonSize`    | `Medium`             | `Small` (32dp), `Medium` (40dp), `Large` (48dp) |
| `enabled`  | `Boolean`         | `true`               | Whether interaction is allowed              |
| `isLoading`| `Boolean`         | `false`              | Shows spinner and blocks interaction        |
| `content`  | `@Composable`     | —                    | Slot for text, icons, or custom content     |

## Switching brands

```kotlin
// The same button, five identities:
DSTheme(brand = Brand.Wireframe) { DSButton(onClick = {}) { Text("Wireframe") } }
DSTheme(brand = Brand.BrandA)    { DSButton(onClick = {}) { Text("iFood")     } }
DSTheme(brand = Brand.BrandB)    { DSButton(onClick = {}) { Text("POS Verde") } }
DSTheme(brand = Brand.BrandC)    { DSButton(onClick = {}) { Text("POS Azul")  } }
DSTheme(brand = Brand.BrandD)    { DSButton(onClick = {}) { Text("POS Roxo")  } }
```

## Token mapping

The Kotlin tokens mirror the JSON sources at `packages/tokens/src/`:

| JSON path                           | Kotlin object / field                         |
|-------------------------------------|-----------------------------------------------|
| `base/colors.json → color.red.500`  | `ColorPrimitives.Red500`                      |
| `brands/brand-a/tokens.json → color.action.primary` | `BrandAColorScheme.actionPrimary` |
| `base/component-button.json → component.button.md.height` | `ButtonTokens.Medium.height` |
| `base/spacing.json → spacing.4`     | `SpacingTokens.Spacing4`                      |

## Best practices applied

- **Immutable data classes** with `@Immutable` for skip-safe recomposition
- **CompositionLocal** for theme propagation (zero prop-drilling)
- **Slot-based content API** for flexible button content (text + icons)
- **Accessibility**: loading state announced via `semantics { stateDescription }`
- **Interaction states**: hover/press via `InteractionSource`
- **Material 3 foundation**: leverages `Button`, `OutlinedButton`, `TextButton`
- **Deterministic sizing**: height + padding driven by component tokens
