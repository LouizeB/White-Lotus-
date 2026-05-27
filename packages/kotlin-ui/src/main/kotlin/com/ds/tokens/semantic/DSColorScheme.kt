package com.ds.tokens.semantic

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Layer 2 — Semantic color tokens.
 *
 * Maps meaning to primitive values. Components consume only these tokens,
 * never raw primitives — enabling brand-switching without changing components.
 *
 * Mirrors the CSS semantic variables (`--ds-color-action-*`, `--ds-color-background-*`, etc.)
 */
@Immutable
data class DSColorScheme(
    // ── Action ──
    val actionPrimary: Color,
    val actionPrimaryHover: Color,
    val actionPrimarySubtle: Color,
    val actionPrimaryForeground: Color,
    val actionSecondaryForeground: Color,

    // ── Background ──
    val backgroundDefault: Color,
    val backgroundSurface: Color,
    val backgroundHover: Color,

    // ── Text ──
    val textPrimary: Color,
    val textSecondary: Color,
    val textInverse: Color,

    // ── Border ──
    val borderDefault: Color,

    // ── Feedback ──
    val feedbackSuccess: Color,
    val feedbackWarning: Color,
    val feedbackError: Color,
    val feedbackInfo: Color,
)

val LocalDSColorScheme = staticCompositionLocalOf<DSColorScheme> {
    error("No DSColorScheme provided. Wrap your composable tree with DSTheme.")
}
