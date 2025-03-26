import java.util.Scanner;

import gerenciador.GerenciadorDeAlunos;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite os números separados por ,  ");
        String input = s.nextLine();
        System.out.println(input);

        // String input = "Beltrana-Feminino, Fulano-Masculino, Ciclano-Masculino, Beltrano-Masculino, Ciclana-Feminino";
        // String input = "Beltrana, Fulano, Ciclano, Beltrano, Ciclana";
        // String input = "Beltrana, Beltrana-Feminino, Fulano, Ciclano, Beltrano, Ciclana, Ciclano-Masculino";

        GerenciadorDeAlunos gerenciador = new GerenciadorDeAlunos(input);
        gerenciador.sortByName();
        gerenciador.showList();
        gerenciador.showGender();
    }
}
