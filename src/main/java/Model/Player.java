package Model;

public class Player {
    private int id;
    private String name;
    private Position position;
    private int number; // Añadido campo number

    // Constructor
    public Player(int id, String name, Position position, int number) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.number = number; // Inicializar número
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
        return number; // Getter para number
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
        this.number = number; // Setter para number
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", number=" + number + // Incluir number en toString
                '}';
    }
}
