package com.ds.tokens.primitives

import androidx.compose.ui.graphics.Color

/**
 * Layer 1 — Primitive tokens.
 *
 * Raw color values that exist independently of any brand.
 * Never reference these directly inside components; use semantic tokens instead.
 *
 * Source of truth: packages/tokens/src/base/colors.json
 */
object ColorPrimitives {

    // ── Neutral ──
    val Neutral0   = Color(0xFFFFFFFF)
    val Neutral50  = Color(0xFFFAFAFA)
    val Neutral100 = Color(0xFFF5F5F5)
    val Neutral200 = Color(0xFFE5E5E5)
    val Neutral300 = Color(0xFFD4D4D4)
    val Neutral400 = Color(0xFFA3A3A3)
    val Neutral500 = Color(0xFF737373)
    val Neutral600 = Color(0xFF525252)
    val Neutral700 = Color(0xFF404040)
    val Neutral800 = Color(0xFF262626)
    val Neutral900 = Color(0xFF171717)

    // ── Wireframe ──
    val Wireframe100 = Color(0xFFF2F2F2)
    val Wireframe200 = Color(0xFFE5E5E5)
    val Wireframe300 = Color(0xFFCCCCCC)
    val Wireframe400 = Color(0xFF999999)
    val Wireframe500 = Color(0xFF666666)

    // ── Red (Brand A — iFood) ──
    val Red50  = Color(0xFFFFF0F0)
    val Red500 = Color(0xFFE00C2C)
    val Red600 = Color(0xFFB8091F)

    // ── Green (Brand B — POS Verde) ──
    val Green50  = Color(0xFFF0FFF0)
    val Green500 = Color(0xFF228B22)
    val Green600 = Color(0xFF1A6B1A)

    // ── Blue (Brand C — POS Azul) ──
    val Blue50  = Color(0xFFF0F7FF)
    val Blue500 = Color(0xFF0066CC)
    val Blue600 = Color(0xFF0052A3)

    // ── Purple (Brand D — POS Roxo) ──
    val Purple50  = Color(0xFFF5F0FF)
    val Purple500 = Color(0xFF6A0DAD)
    val Purple600 = Color(0xFF550A8A)

    // ── Feedback ──
    val FeedbackSuccess = Color(0xFF22C55E)
    val FeedbackWarning = Color(0xFFF59E0B)
    val FeedbackError   = Color(0xFFEF4444)
    val FeedbackInfo    = Color(0xFF3B82F6)
}
