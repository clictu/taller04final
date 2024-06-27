package Model;

public enum Position {
    GK, // Goalkeeper
    DF, // Defender
    MF, // Midfielder
    FW; // Forward

    public static Position fromString(String position) {
        return Position.valueOf(position.toUpperCase());
    }
}
