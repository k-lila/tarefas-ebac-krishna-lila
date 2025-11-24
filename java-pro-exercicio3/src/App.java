import desafio.HorseRide;
import subconjuntos.SubSetFinder;
import troco.Change;

public class App {
    public static void main(String[] args) {
        
        System.out.println("\n#1: De um conjunto, quais os subconjuntos de n elementos?");
        int[] conjunto = {1, 2, 3};
        int n = 2;
        SubSetFinder subSetFinder = new SubSetFinder();
        subSetFinder.findSubsets(conjunto, n);
        System.out.println(subSetFinder);

        System.out.println("\n#2: Qual o troco?");
        int[] moedas = {1, 5, 2};
        int valor = 18;
        Change troco = new Change();
        troco.findCoints(valor, moedas);
        System.out.println(troco);

        System.out.println("\n#3: Passeio do cavalo");
        HorseRide passeio = new HorseRide();
        passeio.caminho(0,0, 3);
        passeio.caminho(0,0, 8);
        passeio.caminho(7,7, 15);
        // passeio.caminho(0, 0, 32);
    }
}