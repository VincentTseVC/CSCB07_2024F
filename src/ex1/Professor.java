package ex1;

public class Professor extends Person {

    public Professor(int sin, String name) {
        super(sin, name);
        Administration.addProfessor(this);
    }

    @Override
    public String toString() {
        return "Prof. " + super.toString();
    }
}
