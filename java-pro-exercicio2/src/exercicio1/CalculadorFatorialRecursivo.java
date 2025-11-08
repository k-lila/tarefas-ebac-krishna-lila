package src.exercicio1;

public class CalculadorFatorialRecursivo {
    public long calcule(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calcule(n - 1);
    }
}