package sngular;

import org.junit.*;
import static org.junit.Assert.*;

public class SubstractionTest {

    private Substraction substraction;
    private static final double DELTA = 1e-15;
    final double n1 = 4;
    final double n2 = 1;

    @Test
    public void resta2numerosCorrectamente() {
        substraction = new Substraction(n1, n2);
        assertEquals(substraction.getRes(), 3, DELTA);
    }

    @Test
    public void resta2numerosErroneamente() {
        substraction = new Substraction(n1, n2);
        assertNotEquals(substraction.getRes(), 1, DELTA);
    }
}
