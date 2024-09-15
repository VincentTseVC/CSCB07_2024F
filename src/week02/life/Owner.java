package week02.life;

import java.util.ArrayList;
import java.util.List;


/**
 *  Association
 *    1. 有個 method 拿進/返回 另一個class
 *
 *    2. 有某個 fields 是屬於 另一個 Class
 *    又稱為: Aggregation
 *
 *      a) Strong Aggregation (Composition)
 *            - House is Composed of Rooms, And Room is part of a House
 *
 *         class House:                     class Room:
 *              list of Rooms
 *
 *      b) Weak Aggregation
 *           - Owner contains a list of cats.
 *          class Owner:                    class Cat:
 *              list of Cats
 */

public class Owner {

    private List<Animal> pets;

    public Owner() {
        this.pets = new ArrayList<>();
    }
    public void addPet(Animal pet) {
        this.pets.add(pet);
    }

    // Polymorphism
    public void whatIHave() {
        for (Animal pet: this.pets) {
            System.out.println(pet.speak());
        }
    }

}
