package sngular;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        assertEquals(6, op.getN1(), DELTA);
    }

    @Test
    public void obtenerN1Erroneo(){
        assertNotEquals(op.getN2(), 6, DELTA);
    }

    @Test
    public void obtenerN2() {
        assertEquals(9, op.getN2(), DELTA);
    }

    @Test
    public void obtenerOperacion() {
        assertEquals('+', op.getOperation());
    }

    @Test
    public void obtenerOperacionErronea() {
        assertNotEquals(op.getOperation(), '-');
    }
}
