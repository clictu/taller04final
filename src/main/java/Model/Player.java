package Model;

public class Player {
    private int number;
    private String name;
    private int age;
    private String position;

    public Player(int number, String name, int age, String position) {
        this.number = number;
        this.name = name;

        this.position = position;
    }

    // Getters and setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +

                ", position='" + position + '\'' +
                '}';
    }
}
