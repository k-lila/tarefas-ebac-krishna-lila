import calculadora.CalculadoraNotas;

public class App {
    public static void main(String[] args) throws Exception {
        CalculadoraNotas calculadora = new CalculadoraNotas();
        int numeroAlunos = 15;
        for (int i = 0; i< numeroAlunos; i++) {
            Double[] listaNotas = {
                Math.random() * 10,
                Math.random() * 10,
                Math.random() * 10,
                Math.random() * 10
            };
            System.out.println("=".repeat(35));
            System.out.println("    Aluno:         " + (i + 1));
            calculadora.calcular(listaNotas);
        }
        System.out.println("=".repeat(35));
    }
}
