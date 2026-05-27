import XCTest
@testable import DesignSystem

final class DSButtonTests: XCTestCase {

    // MARK: - Token Values

    func testSpacingTokensMatchJSON() {
        XCTAssertEqual(DSSpacing.spacing1, 4)
        XCTAssertEqual(DSSpacing.spacing2, 8)
        XCTAssertEqual(DSSpacing.spacing3, 12)
        XCTAssertEqual(DSSpacing.spacing4, 16)
        XCTAssertEqual(DSSpacing.spacing6, 24)
    }

    func testRadiusTokensMatchJSON() {
        XCTAssertEqual(DSRadius.sm, 4)
        XCTAssertEqual(DSRadius.md, 8)
        XCTAssertEqual(DSRadius.lg, 12)
        XCTAssertEqual(DSRadius.xl, 16)
        XCTAssertEqual(DSRadius.full, 9999)
    }

    func testFontSizeTokensMatchJSON() {
        XCTAssertEqual(DSFontSize.xs, 12)
        XCTAssertEqual(DSFontSize.sm, 14)
        XCTAssertEqual(DSFontSize.md, 16)
        XCTAssertEqual(DSFontSize.lg, 18)
    }

    // MARK: - Button Component Tokens

    func testButtonComponentTokens() {
        XCTAssertEqual(DSButtonToken.borderRadius, DSRadius.md)
        XCTAssertEqual(DSButtonToken.borderWidth, 1.5)

        XCTAssertEqual(DSButtonToken.Small.height, 32)
        XCTAssertEqual(DSButtonToken.Small.paddingX, DSSpacing.spacing3)
        XCTAssertEqual(DSButtonToken.Small.fontSize, DSFontSize.sm)

        XCTAssertEqual(DSButtonToken.Medium.height, 40)
        XCTAssertEqual(DSButtonToken.Medium.paddingX, DSSpacing.spacing4)
        XCTAssertEqual(DSButtonToken.Medium.fontSize, DSFontSize.md)

        XCTAssertEqual(DSButtonToken.Large.height, 48)
        XCTAssertEqual(DSButtonToken.Large.paddingX, DSSpacing.spacing6)
        XCTAssertEqual(DSButtonToken.Large.fontSize, DSFontSize.lg)
    }

    // MARK: - Button Size Properties

    func testButtonSizeProperties() {
        XCTAssertEqual(DSButtonSize.sm.height, 32)
        XCTAssertEqual(DSButtonSize.md.height, 40)
        XCTAssertEqual(DSButtonSize.lg.height, 48)

        XCTAssertEqual(DSButtonSize.sm.paddingX, 12)
        XCTAssertEqual(DSButtonSize.md.paddingX, 16)
        XCTAssertEqual(DSButtonSize.lg.paddingX, 24)
    }

    // MARK: - Brand Definitions

    func testAllBrandsExist() {
        XCTAssertEqual(DSBrand.allCases.count, 5)
    }

    func testBrandDisplayNames() {
        XCTAssertEqual(DSBrand.wireframe.displayName, "Wireframe")
        XCTAssertEqual(DSBrand.brandA.displayName, "Brand A — iFood")
        XCTAssertEqual(DSBrand.brandB.displayName, "Brand B — POS Verde")
        XCTAssertEqual(DSBrand.brandC.displayName, "Brand C — POS Azul")
        XCTAssertEqual(DSBrand.brandD.displayName, "Brand D — POS Roxo")
    }

    func testBrandColorsAreNotNil() {
        for brand in DSBrand.allCases {
            let colors = brand.colors
            // Semantic tokens must resolve to concrete colors
            XCTAssertNotNil(colors.actionPrimary)
            XCTAssertNotNil(colors.actionPrimaryForeground)
            XCTAssertNotNil(colors.backgroundDefault)
            XCTAssertNotNil(colors.textPrimary)
        }
    }

    // MARK: - Button Variant

    func testButtonVariantCases() {
        XCTAssertEqual(DSButtonVariant.allCases.count, 3)
        XCTAssertTrue(DSButtonVariant.allCases.contains(.primary))
        XCTAssertTrue(DSButtonVariant.allCases.contains(.secondary))
        XCTAssertTrue(DSButtonVariant.allCases.contains(.ghost))
    }
}
