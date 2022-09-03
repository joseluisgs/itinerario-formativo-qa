package sngular;

import org.junit.*;
import static org.junit.Assert.*;

public class AdditionTest {

    private Addition addition;
    private static final double DELTA = 1e-15;
    final double n1 = 4;
    final double n2 = 1;

    @Test
    public void suma2numerosCorrectamente() {
        addition = new Addition(n1, n2);
        assertEquals(addition.getRes(), 5, DELTA);
    }

    @Test
    public void suma2numerosErroneamente() {
        addition = new Addition(n1, n2);
        assertNotEquals(addition.getRes(), 7, DELTA);
    }
}
