package modulo5.fibonacci;

public class Fibonacci {
    private static final int MAX_ELEMENTOS = 100;
    private static final long[] elementosFib = new long[MAX_ELEMENTOS];

    public static long encontrarElementos(int n) {
        for (int i = 0; i < MAX_ELEMENTOS; i++) {
            elementosFib[i] = -1;
        }
        if (elementosFib[n] == -1) {
            if (n <= 1) {
                elementosFib[n] = 1;
            } else {
                elementosFib[n] = encontrarElementos(n - 1) + encontrarElementos(n - 2);
            }
        }
        return elementosFib[n];
    }

}
