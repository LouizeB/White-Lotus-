package com.ds.tokens.semantic.brands

import com.ds.tokens.primitives.ColorPrimitives
import com.ds.tokens.semantic.DSColorScheme

/** Brand B — POS Verde (green, dark theme) */
val BrandBColorScheme = DSColorScheme(
    actionPrimary            = ColorPrimitives.Green500,
    actionPrimaryHover       = ColorPrimitives.Green600,
    actionPrimarySubtle      = ColorPrimitives.Green50,
    actionPrimaryForeground  = ColorPrimitives.Neutral0,
    actionSecondaryForeground = ColorPrimitives.Green500,

    backgroundDefault = ColorPrimitives.Neutral900,
    backgroundSurface = ColorPrimitives.Neutral800,
    backgroundHover   = ColorPrimitives.Neutral700,

    textPrimary   = ColorPrimitives.Neutral0,
    textSecondary = ColorPrimitives.Neutral400,
    textInverse   = ColorPrimitives.Neutral900,

    borderDefault = ColorPrimitives.Neutral700,

    feedbackSuccess = ColorPrimitives.FeedbackSuccess,
    feedbackWarning = ColorPrimitives.FeedbackWarning,
    feedbackError   = ColorPrimitives.FeedbackError,
    feedbackInfo    = ColorPrimitives.FeedbackInfo,
)
