package modulo5.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void testeElementar() {
        assertEquals(Fibonacci.encontrarElementos(0), 1);
        assertEquals(Fibonacci.encontrarElementos(1), 1);
        assertEquals(Fibonacci.encontrarElementos(2), 2);
        assertEquals(Fibonacci.encontrarElementos(3), 3);
        assertEquals(Fibonacci.encontrarElementos(10), 89);
    }

    @Test
    public void testeSequencia() {
        int[] fibonacci = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i < fibonacci.length; i++) {
            assertEquals(fibonacci[i], Fibonacci.encontrarElementos(i));
        }
    }

    @Test
    public void testeLogicaInterna() {
        for (int a = 2; a < 12; a++) {
            int b = a - 1;
            int c = b - 1;
            assertEquals(
                Fibonacci.encontrarElementos(a),
                Fibonacci.encontrarElementos(b) + Fibonacci.encontrarElementos(c)
            );
            assertEquals(
                Fibonacci.encontrarElementos(c),
                Fibonacci.encontrarElementos(a) - Fibonacci.encontrarElementos(b)
            );
        }
    }

}
