package com.ds.tokens.semantic.brands

import com.ds.tokens.primitives.ColorPrimitives
import com.ds.tokens.semantic.DSColorScheme

/** Brand D — POS Roxo (purple, dark theme) */
val BrandDColorScheme = DSColorScheme(
    actionPrimary            = ColorPrimitives.Purple500,
    actionPrimaryHover       = ColorPrimitives.Purple600,
    actionPrimarySubtle      = ColorPrimitives.Purple50,
    actionPrimaryForeground  = ColorPrimitives.Neutral0,
    actionSecondaryForeground = ColorPrimitives.Purple500,

    backgroundDefault = ColorPrimitives.Neutral900,
    backgroundSurface = ColorPrimitives.Neutral800,
    backgroundHover   = ColorPrimitives.Neutral700,

    textPrimary   = ColorPrimitives.Neutral0,
    textSecondary = ColorPrimitives.Neutral400,
    textInverse   = ColorPrimitives.Neutral900,

    borderDefault = ColorPrimitives.Neutral600,

    feedbackSuccess = ColorPrimitives.FeedbackSuccess,
    feedbackWarning = ColorPrimitives.FeedbackWarning,
    feedbackError   = ColorPrimitives.FeedbackError,
    feedbackInfo    = ColorPrimitives.FeedbackInfo,
)
