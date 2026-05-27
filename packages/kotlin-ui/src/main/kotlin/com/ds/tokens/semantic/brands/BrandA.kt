package com.ds.tokens.semantic.brands

import com.ds.tokens.primitives.ColorPrimitives
import com.ds.tokens.semantic.DSColorScheme

/** Brand A — iFood (red, light theme) */
val BrandAColorScheme = DSColorScheme(
    actionPrimary            = ColorPrimitives.Red500,
    actionPrimaryHover       = ColorPrimitives.Red600,
    actionPrimarySubtle      = ColorPrimitives.Red50,
    actionPrimaryForeground  = ColorPrimitives.Neutral0,
    actionSecondaryForeground = ColorPrimitives.Red500,

    backgroundDefault = ColorPrimitives.Neutral0,
    backgroundSurface = ColorPrimitives.Neutral50,
    backgroundHover   = ColorPrimitives.Neutral100,

    textPrimary   = ColorPrimitives.Neutral900,
    textSecondary = ColorPrimitives.Neutral500,
    textInverse   = ColorPrimitives.Neutral0,

    borderDefault = ColorPrimitives.Neutral200,

    feedbackSuccess = ColorPrimitives.FeedbackSuccess,
    feedbackWarning = ColorPrimitives.FeedbackWarning,
    feedbackError   = ColorPrimitives.FeedbackError,
    feedbackInfo    = ColorPrimitives.FeedbackInfo,
)
