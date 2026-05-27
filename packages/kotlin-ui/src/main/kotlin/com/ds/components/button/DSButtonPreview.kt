package com.ds.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
