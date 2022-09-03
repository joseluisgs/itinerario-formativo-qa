package sngular;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SubtractionTest {

    private Subtraction subtraction;
    private static final double DELTA = 1e-15;
    final double n1 = 4;
    final double n2 = 1;

    @Test
    public void resta2numerosCorrectamente() {
        subtraction = new Subtraction(n1, n2);
        assertEquals(subtraction.getRes(), 3.0, DELTA);
    }

    @Test
    public void resta2numerosErroneamente() {
        subtraction = new Subtraction(n1, n2);
        assertNotEquals(subtraction.getRes(), 1.0, DELTA);
    }
}
