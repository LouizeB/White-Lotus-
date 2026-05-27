package com.ds.tokens.primitives

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Layer 1 — Primitive typography tokens.
 *
 * Source of truth: packages/tokens/src/base/typography.json
 */
object TypographyTokens {

    // ── Font families ──
    val FamilySans: FontFamily = FontFamily.SansSerif
    val FamilyMono: FontFamily = FontFamily.Monospace

    // ── Font sizes ──
    val SizeXs:  TextUnit = 12.sp
    val SizeSm:  TextUnit = 14.sp
    val SizeMd:  TextUnit = 16.sp
    val SizeLg:  TextUnit = 18.sp
    val SizeXl:  TextUnit = 20.sp
    val Size2xl: TextUnit = 24.sp
    val Size3xl: TextUnit = 30.sp
    val Size4xl: TextUnit = 36.sp

    // ── Font weights ──
    val WeightRegular:  FontWeight = FontWeight.Normal    // 400
    val WeightMedium:   FontWeight = FontWeight.Medium    // 500
    val WeightSemibold: FontWeight = FontWeight.SemiBold  // 600
    val WeightBold:     FontWeight = FontWeight.Bold      // 700

    // ── Line heights ──
    val LineHeightTight:   Float = 1.25f
    val LineHeightNormal:  Float = 1.5f
    val LineHeightRelaxed: Float = 1.75f
}
