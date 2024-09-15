package week02.life;



public class Dog extends Animal {

    public Dog(String animal_name, int age) {
        super(animal_name, age); // 調用 Animal constructor
    }

    public Dog(String animal_name) {
        super(animal_name);     // 調用 Animal constructor
    }

    @Override
    public String speak() {
        return "汪汪汪";
    }


}
