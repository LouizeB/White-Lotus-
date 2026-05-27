import SwiftUI

// MARK: - Primitive Colors (Layer 1)
// Raw values independent of brand. Never used directly in components.

public enum DSColorPrimitive {
    public enum Neutral {
        public static let shade0   = Color(hex: "#FFFFFF")
        public static let shade50  = Color(hex: "#FAFAFA")
        public static let shade100 = Color(hex: "#F5F5F5")
        public static let shade200 = Color(hex: "#E5E5E5")
        public static let shade300 = Color(hex: "#D4D4D4")
        public static let shade400 = Color(hex: "#A3A3A3")
        public static let shade500 = Color(hex: "#737373")
        public static let shade600 = Color(hex: "#525252")
        public static let shade700 = Color(hex: "#404040")
        public static let shade800 = Color(hex: "#262626")
        public static let shade900 = Color(hex: "#171717")
    }

    public enum Red {
        public static let shade50  = Color(hex: "#FFF0F0")
        public static let shade500 = Color(hex: "#E00C2C")
        public static let shade600 = Color(hex: "#B8091F")
    }

    public enum Green {
        public static let shade50  = Color(hex: "#F0FFF0")
        public static let shade500 = Color(hex: "#228B22")
        public static let shade600 = Color(hex: "#1A6B1A")
    }

    public enum Blue {
        public static let shade50  = Color(hex: "#F0F7FF")
        public static let shade500 = Color(hex: "#0066CC")
        public static let shade600 = Color(hex: "#0052A3")
    }

    public enum Purple {
        public static let shade50  = Color(hex: "#F5F0FF")
        public static let shade500 = Color(hex: "#6A0DAD")
        public static let shade600 = Color(hex: "#550A8A")
    }

    public enum Wireframe {
        public static let shade100 = Color(hex: "#F2F2F2")
        public static let shade200 = Color(hex: "#E5E5E5")
        public static let shade300 = Color(hex: "#CCCCCC")
        public static let shade400 = Color(hex: "#999999")
        public static let shade500 = Color(hex: "#666666")
    }

    public enum Feedback {
        public static let success = Color(hex: "#22C55E")
        public static let warning = Color(hex: "#F59E0B")
        public static let error   = Color(hex: "#EF4444")
        public static let info    = Color(hex: "#3B82F6")
    }
}

// MARK: - Semantic Colors (Layer 2)
// These are the tokens components consume. They change per brand.

public struct DSSemanticColors {
    public let actionPrimary: Color
    public let actionPrimaryHover: Color
    public let actionPrimarySubtle: Color
    public let actionPrimaryForeground: Color
    public let actionSecondaryForeground: Color

    public let backgroundDefault: Color
    public let backgroundSurface: Color
    public let backgroundHover: Color

    public let textPrimary: Color
    public let textSecondary: Color
    public let textInverse: Color

    public let borderDefault: Color

    public let feedbackSuccess: Color
    public let feedbackWarning: Color
    public let feedbackError: Color
    public let feedbackInfo: Color
}
