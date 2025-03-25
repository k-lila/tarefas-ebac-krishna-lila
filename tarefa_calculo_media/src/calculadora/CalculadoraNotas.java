package calculadora;

public class CalculadoraNotas {
    private double[] notas;
    public CalculadoraNotas(double[] listaNotas) {
        this.notas = listaNotas;
    }
    public double getMedia() {
        double numerador = 0;
        for (double i : this.notas) {
            numerador += i;
        }
        double denominador = this.notas.length;
        return numerador / denominador;
    }
}
