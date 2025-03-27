import classes.PessoaFisica;
import classes.PessoaJuridica;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=".repeat(60));
        PessoaFisica joao = new PessoaFisica("Joao");
        joao.identificar("123123-12");
        joao.setLocalNascimento("Rua Java, n. 21.0.6 2025-01-21");
        joao.mostrarDados("CPF");
        System.out.println(" Local de nascimento: " + joao.getLocalNascimento());
        System.out.println("-".repeat(60));
        PessoaJuridica lojaDoJoao = new PessoaJuridica("Loja do Joao");
        lojaDoJoao.identificar("123123/12323");
        lojaDoJoao.setLocalizacao("Rua OpenJDK build 21.0.6+7-Ubuntu-124.04.1");
        lojaDoJoao.mostrarDados("CNPJ");
        System.out.println(" Localização: " + lojaDoJoao.getLocalizacao());
        System.out.println("=".repeat(60));
    }
}
