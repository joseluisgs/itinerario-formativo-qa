package sngular;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AdditionTest {

    private Addition suma;
    private static final double DELTA = 1e-15;
    final double n1 = 4;
    final double n2 = 1;

    @Test
    public void suma2numerosCorrectamente() {
        suma = new Addition(n1, n2);
        assertEquals(suma.getRes(), 5.0, DELTA);
    }

    @Test
    public void suma2numerosErroneamente() {
        suma = new Addition(n1, n2);
        assertNotEquals(suma.getRes(), 7.0, DELTA);
    }
}
