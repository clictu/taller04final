package Model;

public class Player {
    private int id;
    private String name;
    private Position position;
    private int number; // Añadido campo number

    // Constructor
    public Player(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = Position.fromString(position);
        // Para evitar errores en la carga de jugadores, definiré un valor por defecto para el número del jugador
        this.number = 0; // Puedes ajustar esto según el diseño de tu aplicación
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", number=" + number +
                '}';
    }
}
