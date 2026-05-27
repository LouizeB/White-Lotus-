package com.ds.components.button

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ds.theme.DSTheme
import com.ds.tokens.component.ButtonTokens
import com.ds.tokens.primitives.SpacingTokens

// ─────────────────────────────────────────────────────────────────────────────
// Public API
// ─────────────────────────────────────────────────────────────────────────────

enum class DSButtonVariant { Primary, Secondary, Ghost }

enum class DSButtonSize(internal val tokens: com.ds.tokens.component.ButtonSizeTokens) {
    Small(ButtonTokens.Small),
    Medium(ButtonTokens.Medium),
    Large(ButtonTokens.Large),
}

// ─────────────────────────────────────────────────────────────────────────────
// Slot-based DSButton (low-level)
// ─────────────────────────────────────────────────────────────────────────────

/**
 * Design-system Button — Jetpack Compose (slot-based).
 *
 * Follows the same token-driven, multi-brand architecture as the React
 * `<Button>` in `packages/ui`, reading semantic + component tokens so that
 * a brand switch at the [DSTheme] level changes the visual identity with
 * zero changes in consuming code.
 *
 * @param onClick callback for click events (suppressed while loading/disabled)
 * @param modifier standard Compose modifier
 * @param variant visual style — Primary / Secondary / Ghost
 * @param size button dimensions — Small (32dp) / Medium (40dp) / Large (48dp)
 * @param enabled whether the button accepts interaction
 * @param isLoading shows a spinner and blocks interaction
 * @param isFullWidth stretches the button to fill the available width
 * @param content slot for text, icons, or any composable row content
 */
@Composable
fun DSButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: DSButtonVariant = DSButtonVariant.Primary,
    size: DSButtonSize = DSButtonSize.Medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    isFullWidth: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = DSTheme.colors
    val sizeTokens = size.tokens
    val shape = RoundedCornerShape(ButtonTokens.BorderRadius)
    val effectiveEnabled = enabled && !isLoading

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()

    val hapticFeedback = LocalHapticFeedback.current

    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1.0f,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 800f),
        label = "press-scale",
    )

    val loadingSemantics = if (isLoading) {
        Modifier.semantics { stateDescription = "Loading" }
    } else {
        Modifier
    }

    val fullWidthModifier = if (isFullWidth) Modifier.fillMaxWidth() else Modifier

    val commonModifier = modifier
        .then(fullWidthModifier)
        .then(loadingSemantics)
        .height(sizeTokens.height)
        .defaultMinSize(minWidth = sizeTokens.height)
        .scale(pressScale)

    val contentPadding = PaddingValues(horizontal = sizeTokens.paddingX)

    val textStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = ButtonTokens.FontWeight,
        fontSize = sizeTokens.fontSize,
    )

    val wrappedOnClick: () -> Unit = {
        if (!isLoading) {
            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        }
    }

    when (variant) {
        DSButtonVariant.Primary -> {
            val containerColor = resolveContainerColor(
                base = colors.actionPrimary,
                hover = colors.actionPrimaryHover,
                isHovered = isHovered,
                isPressed = isPressed,
            )
            Button(
                onClick = wrappedOnClick,
                modifier = commonModifier,
                enabled = effectiveEnabled,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = containerColor,
                    contentColor = colors.actionPrimaryForeground,
                    disabledContainerColor = colors.actionPrimary.copy(alpha = 0.4f),
                    disabledContentColor = colors.actionPrimaryForeground.copy(alpha = 0.4f),
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
            ) {
                ButtonContent(
                    isLoading = isLoading,
                    spinnerColor = colors.actionPrimaryForeground,
                    spinnerSize = sizeTokens.spinnerSize,
                    textStyle = textStyle,
                    content = content,
                )
            }
        }

        DSButtonVariant.Secondary -> {
            val borderColor = if (effectiveEnabled) {
                colors.actionSecondaryForeground
            } else {
                colors.actionSecondaryForeground.copy(alpha = 0.4f)
            }
            OutlinedButton(
                onClick = wrappedOnClick,
                modifier = commonModifier,
                enabled = effectiveEnabled,
                shape = shape,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (isHovered || isPressed) colors.backgroundHover else Color.Transparent,
                    contentColor = colors.actionSecondaryForeground,
                    disabledContentColor = colors.actionSecondaryForeground.copy(alpha = 0.4f),
                ),
                border = BorderStroke(ButtonTokens.BorderWidth, borderColor),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
            ) {
                ButtonContent(
                    isLoading = isLoading,
                    spinnerColor = colors.actionSecondaryForeground,
                    spinnerSize = sizeTokens.spinnerSize,
                    textStyle = textStyle,
                    content = content,
                )
            }
        }

        DSButtonVariant.Ghost -> {
            TextButton(
                onClick = wrappedOnClick,
                modifier = commonModifier,
                enabled = effectiveEnabled,
                shape = shape,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (isHovered || isPressed) colors.backgroundHover else Color.Transparent,
                    contentColor = colors.textPrimary,
                    disabledContentColor = colors.textPrimary.copy(alpha = 0.4f),
                ),
                contentPadding = contentPadding,
                interactionSource = interactionSource,
            ) {
                ButtonContent(
                    isLoading = isLoading,
                    spinnerColor = colors.textPrimary,
                    spinnerSize = sizeTokens.spinnerSize,
                    textStyle = textStyle,
                    content = content,
                )
            }
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Convenience DSButton — mirrors iOS DSButton(title:variant:size:...) API
// ─────────────────────────────────────────────────────────────────────────────

/**
 * Convenience button mirroring the iOS `DSButton(_ title:variant:size:...)` API.
 *
 * Provides a simpler call-site when only text + optional icons are needed,
 * while preserving the same token-driven, multi-brand architecture.
 *
 * @param title the button label
 * @param onClick callback for click events (suppressed while loading/disabled)
 * @param modifier standard Compose modifier
 * @param variant visual style — Primary / Secondary / Ghost
 * @param size button dimensions — Small / Medium / Large
 * @param enabled whether the button accepts interaction
 * @param isLoading shows a spinner and blocks interaction
 * @param isFullWidth stretches the button to fill the available width
 * @param leadingIcon optional icon displayed before the title (hidden while loading)
 * @param trailingIcon optional icon displayed after the title (hidden while loading)
 */
@Composable
fun DSButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: DSButtonVariant = DSButtonVariant.Primary,
    size: DSButtonSize = DSButtonSize.Medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    isFullWidth: Boolean = false,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
) {
    val iconSize = size.tokens.iconSize

    val accessibilityModifier = modifier.semantics(mergeDescendants = true) {
        contentDescription = title
        if (isLoading) stateDescription = "Loading"
        else if (!enabled) stateDescription = "Disabled"
    }

    DSButton(
        onClick = onClick,
        modifier = accessibilityModifier,
        variant = variant,
        size = size,
        enabled = enabled,
        isLoading = isLoading,
        isFullWidth = isFullWidth,
    ) {
        if (leadingIcon != null && !isLoading) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                modifier = Modifier.size(iconSize),
            )
        }

        Text(text = title, maxLines = 1)

        if (trailingIcon != null && !isLoading) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
                modifier = Modifier.size(iconSize),
            )
        }
    }
}

// ─────────────────────────────────────────────────────────────────────────────
// Internal helpers
// ─────────────────────────────────────────────────────────────────────────────

@Composable
private fun ButtonContent(
    isLoading: Boolean,
    spinnerColor: Color,
    spinnerSize: Dp,
    textStyle: TextStyle,
    content: @Composable () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing2, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (isLoading) {
            LoadingSpinner(color = spinnerColor, size = spinnerSize, strokeWidth = 2.dp)
        }
        androidx.compose.runtime.CompositionLocalProvider(
            androidx.compose.material3.LocalTextStyle provides textStyle,
            content = content,
        )
    }
}

@Composable
private fun LoadingSpinner(
    color: Color,
    size: Dp,
    strokeWidth: Dp,
    modifier: Modifier = Modifier,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "spinner")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 600, easing = LinearEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "spinner-rotation",
    )

    androidx.compose.foundation.Canvas(
        modifier = modifier
            .size(size)
            .rotate(rotation),
    ) {
        val strokePx = strokeWidth.toPx()
        drawArc(
            color = color,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(strokePx / 2, strokePx / 2),
            size = Size(this.size.width - strokePx, this.size.height - strokePx),
            style = Stroke(width = strokePx, cap = StrokeCap.Round),
        )
    }
}

private fun resolveContainerColor(
    base: Color,
    hover: Color,
    isHovered: Boolean,
    isPressed: Boolean,
): Color = when {
    isPressed -> hover
    isHovered -> hover
    else      -> base
}
