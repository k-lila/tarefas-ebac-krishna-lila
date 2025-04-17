import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // String inputString = "A-Homem, B-Mulher, C-Homem, D-Mulher, E-Mulher, F-Homem, G-Homem, H-Mulher";
        String inputString = JOptionPane.showInputDialog(null, "Digite seguindo o padrão: *Nome-Sexo, Nome-Sexo...*\ncomo: Fulano-Homem, Maria-Mulher", JOptionPane.INFORMATION_MESSAGE);
        List<String> mulheres = Arrays.asList(inputString.split(", ")).stream()
            .filter(pessoa -> pessoa.contains("-") && pessoa.split("-").length == 2)
            .filter(pessoa -> pessoa.split("-")[1]
            .equals("Mulher"))
            .toList();
        System.out.println(mulheres);
        String output = mulheres.size() >= 1 ? mulheres.stream()
            .map(m -> m.split("-")[0])
            .reduce("\n", (a, b) -> a + b + "\n") : "\nNão há mulheres na lista"; 
        JOptionPane.showMessageDialog(null, "Mulheres:" + output);
    }
}
