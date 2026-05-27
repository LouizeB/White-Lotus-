package com.ds.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ds.theme.Brand
import com.ds.theme.DSTheme
import com.ds.tokens.primitives.SpacingTokens

@Preview(showBackground = true, name = "DSButton — All Variants (Brand A)")
@Composable
private fun DSButtonVariantsPreview() {
    DSTheme(brand = Brand.BrandA) {
        Column(
            modifier = Modifier.padding(SpacingTokens.Spacing4),
            verticalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing3),
        ) {
            DSButton(onClick = {}, variant = DSButtonVariant.Primary) {
                Text("Primary")
            }
            DSButton(onClick = {}, variant = DSButtonVariant.Secondary) {
                Text("Secondary")
            }
            DSButton(onClick = {}, variant = DSButtonVariant.Ghost) {
                Text("Ghost")
            }
        }
    }
}

@Preview(showBackground = true, name = "DSButton — All Sizes")
@Composable
private fun DSButtonSizesPreview() {
    DSTheme(brand = Brand.BrandA) {
        Row(
            modifier = Modifier.padding(SpacingTokens.Spacing4),
            horizontalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing2),
        ) {
            DSButton(onClick = {}, size = DSButtonSize.Small) { Text("Small") }
            DSButton(onClick = {}, size = DSButtonSize.Medium) { Text("Medium") }
            DSButton(onClick = {}, size = DSButtonSize.Large) { Text("Large") }
        }
    }
}

@Preview(showBackground = true, name = "DSButton — States")
@Composable
private fun DSButtonStatesPreview() {
    DSTheme(brand = Brand.BrandC) {
        Column(
            modifier = Modifier.padding(SpacingTokens.Spacing4),
            verticalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing3),
        ) {
            DSButton(onClick = {}) { Text("Enabled") }
            DSButton(onClick = {}, enabled = false) { Text("Disabled") }
            DSButton(onClick = {}, isLoading = true) { Text("Loading...") }
        }
    }
}

@Preview(showBackground = true, name = "DSButton — Convenience API with Icons")
@Composable
private fun DSButtonConveniencePreview() {
    DSTheme(brand = Brand.BrandA) {
        Column(
            modifier = Modifier.padding(SpacingTokens.Spacing4),
            verticalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing3),
        ) {
            DSButton(
                title = "Add Item",
                onClick = {},
                leadingIcon = Icons.Filled.Add,
            )
            DSButton(
                title = "Next",
                onClick = {},
                trailingIcon = Icons.Filled.ArrowForward,
            )
            DSButton(
                title = "Favorite",
                onClick = {},
                leadingIcon = Icons.Filled.Favorite,
                trailingIcon = Icons.Filled.ArrowForward,
            )
            DSButton(
                title = "Loading",
                onClick = {},
                isLoading = true,
                leadingIcon = Icons.Filled.Add,
            )
            DSButton(
                title = "Disabled",
                onClick = {},
                enabled = false,
                leadingIcon = Icons.Filled.Add,
            )
        }
    }
}

@Preview(showBackground = true, name = "DSButton — Full Width")
@Composable
private fun DSButtonFullWidthPreview() {
    DSTheme(brand = Brand.BrandA) {
        Column(
            modifier = Modifier.padding(SpacingTokens.Spacing4),
            verticalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing3),
        ) {
            DSButton(
                title = "Confirm Payment",
                onClick = {},
                variant = DSButtonVariant.Primary,
                size = DSButtonSize.Large,
                isFullWidth = true,
            )
            DSButton(
                title = "Cancel",
                onClick = {},
                variant = DSButtonVariant.Secondary,
                isFullWidth = true,
            )
            DSButton(
                title = "Learn More",
                onClick = {},
                variant = DSButtonVariant.Ghost,
                isFullWidth = true,
            )
        }
    }
}

@Preview(showBackground = true, name = "DSButton — Sizes with Convenience API")
@Composable
private fun DSButtonConvenienceSizesPreview() {
    DSTheme(brand = Brand.BrandB) {
        Column(
            modifier = Modifier.padding(SpacingTokens.Spacing4),
            verticalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing3),
        ) {
            DSButton(title = "Small", onClick = {}, size = DSButtonSize.Small, leadingIcon = Icons.Filled.Add)
            DSButton(title = "Medium", onClick = {}, size = DSButtonSize.Medium, leadingIcon = Icons.Filled.Add)
            DSButton(title = "Large", onClick = {}, size = DSButtonSize.Large, leadingIcon = Icons.Filled.Add)
        }
    }
}

@Preview(showBackground = true, name = "DSButton — Multi-brand")
@Composable
private fun DSButtonMultiBrandPreview() {
    Column(
        modifier = Modifier.padding(SpacingTokens.Spacing4),
        verticalArrangement = Arrangement.spacedBy(SpacingTokens.Spacing3),
    ) {
        Brand.entries.forEach { brand ->
            DSTheme(brand = brand) {
                DSButton(onClick = {}) {
                    Text(brand.name)
                }
            }
        }
    }
}
