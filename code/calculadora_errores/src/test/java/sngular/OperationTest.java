package sngular;

import org.junit.*;
import static org.junit.Assert.*;

public class OperationTest {

    private static final double DELTA = 1e-15;
    private Operation op;
    final double n1 = 6;
    final double n2 = 9;
    final char operacion = '+';

    @Before
    public void inicializar(){
        op = new Operation(n1, n2, operacion);
    }

    @Test
    public void obtenerN1() {
        assertEquals(op.getN1(), 6, DELTA);
    }

    @Test
    public void obtenerN1Erroneo(){
        assertNotEquals(op.getN2(), 6, DELTA);
    }

    @Test
    public void obtenerN2() {
        assertEquals(op.getN2(), 9, DELTA);
    }

    @Test
    public void obtenerOperacion() {
        assertEquals(op.getOperation(), '+');
    }

    @Test
    public void obtenerOperacionErronea() {
        assertNotEquals(op.getOperation(), '-');
    }
}
