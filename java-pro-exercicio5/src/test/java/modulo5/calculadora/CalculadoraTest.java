package modulo5.calculadora;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();
    private int numA = 5;
    private int numB = 2;
    private int zero = 0;

    @Test
    public void testeSoma() {
        int soma = calculadora.calculeAdicao(numA, numB);
        Assertions.assertEquals(numA + numB, soma);
    }

    @Test
    public void testeSubtracao() {
        int subtracao = calculadora.calculeSubtracao(numA, numB);
        Assertions.assertEquals(numA - numB, subtracao);
    }

    @Test
    public void testeMultiplicacao() {
        int multiplicacao = calculadora.calculeMultiplicacao(numA, numB);
        Assertions.assertEquals(numA * numB, multiplicacao);
    }

    @Test
    public void testeDivisao() {
        int divisao = calculadora.calculeDivisao(numA, numB);
        Assertions.assertEquals(numA / numB, divisao);
    }

    @Test
    public void testeDivisaoZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.calculeDivisao(numA, zero);
        });
    }
}
