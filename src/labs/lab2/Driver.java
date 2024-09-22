
package labs.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args) throws IOException {
        // this   => 6 - 2x + 5x3 + 2x4 => [6, -2, 5, 2] and [0, 1, 3, 4]
        // other  => 5 + 2x + 6x4       => [5,  2, 6]    and [0, 1, 4]

        double[] c1 = {6, -2, 5, 2};
        int[]    e1 = {0, 1, 3, 4};
        Polynomial p1 = new Polynomial(c1, e1);

        double[] c2 = {5, 2, 6};
        int[]    e2 = {0, 1, 4};
        Polynomial p2 = new Polynomial(c2, e2);

        System.out.println("Testing Add...");
        Polynomial r1 = p1.add(p2);

        System.out.println(r1);

        // TODO: do the same thing for testing multiply

        try {
            File file = new File("input.txt");
            Polynomial p3 = new Polynomial(file);

            System.out.println(p3);

            p1.saveToFile("output.txt");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}