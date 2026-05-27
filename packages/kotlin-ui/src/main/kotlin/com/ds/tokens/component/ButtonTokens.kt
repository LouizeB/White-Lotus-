package com.ds.tokens.component

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.ds.tokens.primitives.RadiusTokens
import com.ds.tokens.primitives.SpacingTokens
import com.ds.tokens.primitives.TypographyTokens

/**
 * Layer 3 — Component-level tokens for Button.
 *
 * Maps design-level decisions (sizing, spacing, typography) to concrete values
 * that the Button composable reads. Mirrors `component-button.json`.
 *
 * Source of truth: packages/tokens/src/base/component-button.json
 */
@Immutable
data class ButtonSizeTokens(
    val height: Dp,
    val paddingX: Dp,
    val fontSize: TextUnit,
)

object ButtonTokens {
    val BorderRadius: Dp = RadiusTokens.Md
    val BorderWidth: Dp = Dp(1.5f)
    val FontWeight = TypographyTokens.WeightMedium
    val TransitionDurationMs: Int = 150

    val Small = ButtonSizeTokens(
        height   = Dp(32f),
        paddingX = SpacingTokens.Spacing3,
        fontSize = TypographyTokens.SizeSm,
    )

    val Medium = ButtonSizeTokens(
        height   = Dp(40f),
        paddingX = SpacingTokens.Spacing4,
        fontSize = TypographyTokens.SizeMd,
    )

    val Large = ButtonSizeTokens(
        height   = Dp(48f),
        paddingX = SpacingTokens.Spacing6,
        fontSize = TypographyTokens.SizeLg,
    )
}
