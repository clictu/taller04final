package Model;

public class Player {
    private int number; // Número de jugador
    private String name;
    private Position position;

    public Player(int number, String name, String position) {
        this.number = number;
        this.name = name;
        this.position = Position.fromString(position);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
