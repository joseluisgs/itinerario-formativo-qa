package sngular;

import org.junit.*;
import static org.junit.Assert.*;

public class MultiplicationTest {

    private Multiplication multi;
    private static final double DELTA = 1e-15;
    final double n1 = 6;
    final double n2 = 9;

    @Test
    public void multiplica2numerosCorrectamente() {
        multi = new Multiplication(n1, n2);
        assertEquals(multi.getRes(), 54, DELTA);
    }

    @Test
    public void multiplica2numerosErroneamente() {
        multi = new Multiplication(n1, n2);
        assertNotEquals(multi.getRes(), 60, DELTA);
    }
}
