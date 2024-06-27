package Model;

public class Player {
    private int number;
    private String name;
    private Position position;

    public Player(int number, String name, Position position) {
        this.number = number;
        this.name = name;
        this.position = position;
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    // Setters (opcional, dependiendo de tus necesidades)
    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
