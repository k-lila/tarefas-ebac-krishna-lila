package src.exercicio2;

public class CalculadorFatorialDinamico {
    private int MAX_ELEMENTS = 100;
    private long[] elements = new long[MAX_ELEMENTS];

    public CalculadorFatorialDinamico() {
        for (int i = 0; i < 100; i++) {
            elements[i] = -1;
        }
    }

    public long calculeTopDown(int n) {
        if (n <= 1) {
            elements[n] = 1;
        } else {
            elements[n] = n * calculeTopDown(n - 1);
        }
        return elements[n];
    }

    public long calculeBottomUp(int n) {
        elements[0] = 1;
        for (int i = 1; i <= n; i ++) {
            elements[i] = i * elements[i - 1];  
        }
        return elements[n];
    }
}
