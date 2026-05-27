package com.ds.tokens.semantic.brands

import com.ds.tokens.primitives.ColorPrimitives
import com.ds.tokens.semantic.DSColorScheme

val WireframeColorScheme = DSColorScheme(
    actionPrimary            = ColorPrimitives.Wireframe400,
    actionPrimaryHover       = ColorPrimitives.Wireframe500,
    actionPrimarySubtle      = ColorPrimitives.Wireframe100,
    actionPrimaryForeground  = ColorPrimitives.Neutral0,
    actionSecondaryForeground = ColorPrimitives.Wireframe500,

    backgroundDefault = ColorPrimitives.Neutral0,
    backgroundSurface = ColorPrimitives.Wireframe100,
    backgroundHover   = ColorPrimitives.Wireframe200,

    textPrimary   = ColorPrimitives.Wireframe500,
    textSecondary = ColorPrimitives.Wireframe400,
    textInverse   = ColorPrimitives.Neutral0,

    borderDefault = ColorPrimitives.Wireframe200,

    feedbackSuccess = ColorPrimitives.Wireframe300,
    feedbackWarning = ColorPrimitives.Wireframe300,
    feedbackError   = ColorPrimitives.Wireframe300,
    feedbackInfo    = ColorPrimitives.Wireframe300,
)
