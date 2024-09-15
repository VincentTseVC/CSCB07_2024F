package week02;

import week02.life.*;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello World");

        // Primitive Types (Value Types)
        int a = 65;     // 4 bytes, 32 bits, 2^32 -> 21億4700萬...
        float f = 1;
        double d = 3.14159;
        long l = 100000;    // 8 bytes
        boolean b = true;
        char c = 'A'; // 65
        short s = 259;  // 2 bytes, 16 bits

        int z = s;
        // 259 -> 256 + 2 + 1
        // s -> 0000 0001 0000 0011
        // z -> 0000 0000 0000 0000 0000 0001 0000 0011

        byte b1 = (byte) s;
        // s  -> 0000 0001 0000 0011
        // b1 -> 0000 0011

        System.out.println(s);
        System.out.println(z);
        System.out.println(b1);

        // Reference Type (object Type)
        // Think as a compound data type in c (struct)
        // has different fields, and methods, not just a value
        // it is created in the "HEAP", using something like calloc ...
        // ** variable store the "memory address of the object"

        String s1 = new String("CSCB07"); // calloc
        String s2 = new String("CSCB07"); // calloc

        String s3 = "CSCB07"; // String-literal (short-cut to create a string)
                              // Immutable

        String s4 = "CSCB07"; // java will first check String-Pool, if this string exist or not
                              // if not, create new string

        // same object? same memory address?
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        // Same content?
        System.out.println(s1.equals(s2));

        Integer int1 = new Integer(5);
        Integer int2 = 5;   // auto-boxing
        int k = int2;       // auto-unboxing

        // ----------------
        Dog nioki = new Dog("Nioki", 3);  // automatically call contractor()
        nioki.setName("Nioky");
        System.out.println(nioki.getName());
        System.out.println(Animal.numberOfAnimals); // 1

        Cat bob = new Cat("Bob");
        System.out.println(Animal.numberOfAnimals); // 2

        System.out.println(nioki);  // Dog.toString()
        System.out.println(bob);    // Cat.toString()

        // Animal vc = new Animal();
        Animal alice = new Dog("Alice"); // reference Type = actual Object

        Animal bee = new Bee("Beeeeee");
        // System.out.println(bee.get...); 看不到 getNumLegs()
        System.out.println(((Insect) bee).getNumOfLegs());
        System.out.println(((Bee) bee).getNumOfLegs());

        Flyable bee2 = new Bee("Beeeeee!");


        Owner anya = new Owner();
        anya.addPet(nioki);
        anya.addPet(bob);
        anya.addPet(bee);

        anya.whatIHave();

    }
}
