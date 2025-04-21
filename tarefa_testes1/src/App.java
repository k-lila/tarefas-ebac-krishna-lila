import javax.swing.JOptionPane;

import filter.Filter;

public class App {
    public static void main(String[] args) throws Exception {
        String inputString = JOptionPane.showInputDialog(null, "Digite seguindo o padrão: *Nome-Sexo, Nome-Sexo...*\ncomo: Fulano-Homem, Maria-Mulher", JOptionPane.INFORMATION_MESSAGE);
        Filter filter = new Filter(inputString);
        System.out.println(filter.getMulheres());
    }
}
