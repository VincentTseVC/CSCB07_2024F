package week02.life;

public abstract class Insect extends Animal {

    private int numOfLegs;

    public Insect(String animal_name, int age) {
        super(animal_name, age);
        numOfLegs = 6;
    }

    public Insect(String animal_name) {
        super(animal_name);
        numOfLegs = 6;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }
}
