import calculadora.CalculadoraNotas;

public class App {
    public static void main(String[] args) throws Exception {
        double[] notas = {
            7.0,
            8.5,
            9.0,
            9.5
        };
        CalculadoraNotas calcula = new CalculadoraNotas(notas);
        System.out.println(calcula.getMedia());
    }
}
