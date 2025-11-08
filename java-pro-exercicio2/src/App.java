package src;

import src.exercicio1.CalculadorFatorialRecursivo;
import src.exercicio2.CalculadorFatorialDinamico;

public class App {
    public static void main(String[] args) {
        int nMin = 0;
        int nTest = 7;
        int nMax = 39;
        System.out.println("\nRecursivo:");
        CalculadorFatorialRecursivo cfr = new CalculadorFatorialRecursivo();
        System.out.println("n = 0:  " + cfr.calcule(nMin));
        System.out.println("n = 7:  " + cfr.calcule(nTest));
        System.out.println("n = 39: " + cfr.calcule(nMax));
        System.out.println("\n######\n");
        System.out.println("Dinâmico:");
        CalculadorFatorialDinamico cfd = new CalculadorFatorialDinamico();
        System.out.println("n = 0  | Bottom Up: " + cfd.calculeBottomUp(nMin));
        System.out.println("n = 0  | Top Down:  " + cfd.calculeTopDown(nMin));
        System.out.println("n = 7  | Bottom Up: " + cfd.calculeBottomUp(nTest));
        System.out.println("n = 7  | Top Down:  " + cfd.calculeTopDown(nTest));
        System.out.println("n = 39 | Bottom Up: " + cfd.calculeBottomUp(nMax));
        System.out.println("n = 39 | Top Down:  " + cfd.calculeTopDown(nMax));
    }
}
