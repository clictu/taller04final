package Model;

public enum Position {
    GK, // Goalkeeper
    DF, // Defender
    MF, // Midfielder
    FW; // Forward

    // Método estático para convertir una cadena en un valor del enum
    public static Position fromString(String position) {
        return Position.valueOf(position.toUpperCase()); // Convierte la cadena a mayúsculas y luego obtiene el enum correspondiente
    }
}
