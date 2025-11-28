package modulo5.calculadora;

/**
 * {@code Calculadora} possui quatro métodos,
 * um para cada operação aritmética básica: adição,
 * subtração, multiplicação e divisão.
 * Manipula apenas números inteiros.
 */
public class Calculadora {

    private int adicionar(int a, int b) { return a + b; }
    private int subtrair(int a, int b) { return a - b; }
    private int multiplicar(int a, int b) { return a * b; }
    private int dividir(int a, int b) { return a / b; }

    /**
     * calcula a adição entre dois números inteiros
     * @param a primeiro termo
     * @param b segundo termo
     * @return soma entre os parâmetros
     */
    public int calculeAdicao(int a, int b) {
        return adicionar(a, b);
    }

    /**
     * calcula a subtração entre dois números inteiros
     * @param a minuendo
     * @param b subtraendo
     * @return diferença entre os parâmetros
     */
    public int calculeSubtracao(int a, int b) {
        return subtrair(a, b);
    }

    /**
     * calcula a multiplicação entre dois números inteiros
     * @param a multiplicando
     * @param b multiplicador
     * @return produto entre os parâmetros
     */
    public int calculeMultiplicacao(int a, int b) {
        return multiplicar(a, b);
    }

    /**
     * calcula a divisão entre dois números inteiros
     * @param a dividendo
     * @param b divisor
     * @return quociente entre os parâmetros
     * @throws ArithmeticException em caso de divisão por 0
     */ 
    public int calculeDivisao(int a, int b) throws ArithmeticException {
        return dividir(a, b);
    }
}
