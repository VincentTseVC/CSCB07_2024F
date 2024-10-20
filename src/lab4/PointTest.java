package lab4;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public void testConstructorAndGetters() {
        Point p = new Point(3.0, 4.0);
        assertEquals(3.0, p.x);
        assertEquals(4.0, p.y);
    }

    @Test
    public void testDistanceSamePoint() {
        Point p1 = new Point(0.0, 0.0);
        assertEquals(0.0, p1.distance(p1));
    }

    @Test
    public void testDistanceDifferentPoints() {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(3.0, 4.0);
        assertEquals(5.0, p1.distance(p2));
    }

    @Test
    public void testHashCode() {
        Point p = new Point(2.0, 3.0);
        assertEquals(3 * 2.0 + 5 * 3.0, p.hashCode());
    }

    @Test
    public void testEqualsSamePoint() {
        Point p1 = new Point(1.0, 1.0);
        assertTrue(p1.equals(p1));
    }

    @Test
    public void testEqualsNull() {
        Point p1 = new Point(1.0, 1.0);
        assertFalse(p1.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        Point p1 = new Point(1.0, 1.0);
        String other = "Not a point";
        assertFalse(p1.equals(other));
    }

    @Test
    public void testEqualsDifferentPoint() {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEqualsSameCoordinates() {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(1.0, 1.0);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testEqualsDifferentX() {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 1.0);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEqualsDifferentY() {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(1.0, 2.0);
        assertFalse(p1.equals(p2));
    }
}
