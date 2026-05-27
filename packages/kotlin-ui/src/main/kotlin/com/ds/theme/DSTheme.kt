package com.ds.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.ds.tokens.semantic.DSColorScheme
import com.ds.tokens.semantic.LocalDSColorScheme
import com.ds.tokens.semantic.brands.BrandAColorScheme
import com.ds.tokens.semantic.brands.BrandBColorScheme
import com.ds.tokens.semantic.brands.BrandCColorScheme
import com.ds.tokens.semantic.brands.BrandDColorScheme
import com.ds.tokens.semantic.brands.WireframeColorScheme

/** Available brands in the design system. */
enum class Brand {
    Wireframe,
    BrandA,
    BrandB,
    BrandC,
    BrandD,
}

/**
 * Root theme composable.
 *
 * Wraps the tree with the correct [DSColorScheme] based on the selected [brand].
 * Every DS component reads colors via [DSTheme.colors].
 *
 * Usage:
 * ```kotlin
 * DSTheme(brand = Brand.BrandA) {
 *     DSButton(onClick = { }) { Text("Confirmar") }
 * }
 * ```
 */
@Composable
fun DSTheme(
    brand: Brand = Brand.BrandA,
    content: @Composable () -> Unit,
) {
    val colorScheme = when (brand) {
        Brand.Wireframe -> WireframeColorScheme
        Brand.BrandA    -> BrandAColorScheme
        Brand.BrandB    -> BrandBColorScheme
        Brand.BrandC    -> BrandCColorScheme
        Brand.BrandD    -> BrandDColorScheme
    }

    CompositionLocalProvider(
        LocalDSColorScheme provides colorScheme,
        content = content,
    )
}

/** Convenience accessor: `DSTheme.colors.actionPrimary` */
object DSTheme {
    val colors: DSColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalDSColorScheme.current
}
