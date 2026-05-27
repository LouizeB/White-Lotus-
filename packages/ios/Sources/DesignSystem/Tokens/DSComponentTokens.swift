import CoreGraphics

// MARK: - Button Component Tokens

public enum DSButtonToken {
    public static let borderRadius: CGFloat = DSRadius.md
    public static let borderWidth:  CGFloat = 1.5
    public static let fontWeight    = DSFontWeight.medium
    public static let transitionDuration: Double = 0.15

    public enum Small {
        public static let height:    CGFloat = 32
        public static let paddingX:  CGFloat = DSSpacing.spacing3
        public static let fontSize:  CGFloat = DSFontSize.sm
    }

    public enum Medium {
        public static let height:    CGFloat = 40
        public static let paddingX:  CGFloat = DSSpacing.spacing4
        public static let fontSize:  CGFloat = DSFontSize.md
    }

    public enum Large {
        public static let height:    CGFloat = 48
        public static let paddingX:  CGFloat = DSSpacing.spacing6
        public static let fontSize:  CGFloat = DSFontSize.lg
    }
}
