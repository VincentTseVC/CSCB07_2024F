package lab3;


// TODO: Ask piazza / 上完下周的 lec
// TODO: 應該是 Junit 4 還是 Junit 5.8.1 ???

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Lab3Tests {

    @Test
    void testRationalNumberConstructorException() {
        try {
            RationalNumber r = new RationalNumber(1, 0);
            assertFalse(true); // 不應該跑到這一行
        } catch (Lab3Exception ex) {
            assertEquals("Denominator cannot be zero", ex.getMessage());
        }
    }

    @Test
    void testComputeAverageException() {
        try {
            SpecialNumber.computeAverage(null);

        } catch (Lab3Exception ex) {
            assertEquals("List cannot be empty", ex.getMessage());
        }
    }

    // TODO: 把每一個 可能有 Exception 的情況都測一遍

    @Test
    void testRationalNumberHashCode() {
        try {
            RationalNumber r1 = new RationalNumber(1, 2);
            RationalNumber r2 = new RationalNumber(2, 4);
            assertEquals(r1.hashCode(), r2.hashCode());
        } catch (Lab3Exception ex) {
            assertFalse(true);
        }
    }

}
