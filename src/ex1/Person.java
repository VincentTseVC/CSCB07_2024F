package ex1;

public abstract class Person {
    private int sin;
    private String name;

    public Person(int sin, String name) {
        this.sin = sin;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Person)) return false;

        Person other = (Person) o;
        return this.sin == other.sin;
    }

    @Override
    public int hashCode() {
        return this.sin;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int compareName(Person other) {
        if (other == null)
            throw new IllegalArgumentException();
        return this.name.compareTo(other.name);
    }

}
