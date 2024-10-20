package lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    public void testConstructorAndGetters() {
        Point A = new Point(0.0, 0.0);
        Point B = new Point(3.0, 4.0);
        Point C = new Point(6.0, 0.0);
        Triangle t = new Triangle(A, B, C);
        assertEquals(A, t.A);
        assertEquals(B, t.B);
        assertEquals(C, t.C);
    }

    @Test
    public void testPerimeter() {
        Point A = new Point(0.0, 0.0);
        Point B = new Point(3.0, 4.0);
        Point C = new Point(6.0, 0.0);
        Triangle t = new Triangle(A, B, C);
        assertEquals(16.0, t.perimeter());
    }

    @Test
    public void testIsEquilateralFalse() {
        Point A = new Point(0.0, 0.0);
        Point B = new Point(3.0, 4.0);
        Point C = new Point(6.0, 0.0);
        Triangle t = new Triangle(A, B, C);
        assertFalse(t.isEquilateral());
    }

    @Test
    public void testIsEquilateralTrue() {
        Point A = new Point(0.0, 0.0);
        Point B = new Point(Math.sqrt(5), 0.0);
        Point C = new Point(Math.sqrt(5)/2, Math.sqrt(15)/2);
        Triangle t = new Triangle(A, B, C);
        assertTrue(t.isEquilateral());
    }
}