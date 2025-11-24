package troco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {

    List<Integer> coints;
    int total;


    public List<Integer> findCoints(int valor, int[] moedas) {
        total = valor;
        Arrays.sort(moedas);
        int maxIndex = moedas.length - 1;
        coints = new ArrayList<>();
        while (valor > 0) {
            if (maxIndex < 0) {
                if (valor != 0) {
                    System.out.println("sobra: " + valor);
                }
                break;
            }
            if (valor >= moedas[maxIndex]) {
                coints.add(moedas[maxIndex]);
                valor -= moedas[maxIndex];
            } else {
                maxIndex--;
            }
        }
        return coints;
    }

    @Override
    public String toString() {
        String _string = "troco para " + total + ": ";
        for (int moeda : coints) {
            _string += moeda + " ";
        }
        return _string;
    }
}
