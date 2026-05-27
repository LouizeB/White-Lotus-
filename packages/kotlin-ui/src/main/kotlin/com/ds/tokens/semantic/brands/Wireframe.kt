package com.ds.tokens.semantic.brands

import com.ds.tokens.primitives.ColorPrimitives
import com.ds.tokens.semantic.DSColorScheme

val WireframeColorScheme = DSColorScheme(
    actionPrimary            = ColorPrimitives.Wireframe400,
    actionPrimaryHover       = ColorPrimitives.Wireframe500,
    actionPrimarySubtle      = ColorPrimitives.Wireframe100,
    actionPrimaryForeground  = ColorPrimitives.Neutral0,
    actionSecondaryForeground = ColorPrimitives.Wireframe400,

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
