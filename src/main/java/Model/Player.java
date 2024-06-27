package Model;

public class Player {
    private int number; // Nuevo atributo para el número del jugador
    private String name;
    private int age;
    private String position;

    public Player(int number, String name, int age, String position) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Player(String name, int age, String position) {
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }

    public void setName(String newName) {
    }
}
