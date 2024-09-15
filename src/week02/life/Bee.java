package week02.life;

public class Bee extends Insect implements Flyable {
    public Bee(String animal_name, int age) {
        super(animal_name, age);
    }

    public Bee(String animal_name) {
        super(animal_name);
    }

    @Override
    public String speak() {
        return "嗡嗡嗡";
    }

    @Override
    public int getNumberOfWings() {
        return 4;
    }
}
