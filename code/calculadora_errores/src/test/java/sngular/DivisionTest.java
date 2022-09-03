package sngular;

import org.junit.*;
import static org.junit.Assert.*;

public class DivisionTest {

    private Division div;
    private static final double DELTA = 1e-15;
    final double n1 = 21;
    final double n2 = 3;

    @Test
    public void divide2numerosCorrectamente() {
        div = new Division(n1, n2);
        assertEquals(div.getRes(), 7, DELTA);
    }

    @Test
    public void divide2numerosErroneamente() {
        div = new Division(n1, n2);
        assertNotEquals(div.getRes(), 4, DELTA);
    }
}
