package week02.life;

// Inheritance (繼承)
public class Cat extends Animal implements Fuckable {
    public Cat(String animal_name, int age) {
        super(animal_name, age);
    }

    public Cat(String animal_name) {
        super(animal_name);
    }

    @Override
    public String speak() {
        return "喵喵喵";
    }

    @Override
    public void fuck() {

    }
}
