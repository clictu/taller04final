package Model;

public enum Position {
    GK,
    DF,
    MF,
    FW;

    public static Position fromString(String position) {
        switch (position.trim().toUpperCase()) {
            case "GK":
                return GK;
            case "DF":
                return DF;
            case "MF":
                return MF;
            case "FW":
                return FW;
            default:
                throw new IllegalArgumentException("Unknown position: " + position);
        }
    }
}
