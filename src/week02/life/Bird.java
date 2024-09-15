package week02.life;

public class Bird extends Animal implements Flyable, Fuckable {
    public Bird(String animal_name, int age) {
        super(animal_name, age);
    }

    public Bird(String animal_name) {
        super(animal_name);
    }

    @Override
    public String speak() {
        return "唧唧唧";
    }

    @Override
    public int getNumberOfWings() {
        return 2;
    }

    @Override
    public void fuck() {

    }
}
