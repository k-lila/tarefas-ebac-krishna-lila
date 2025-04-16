
import java.lang.annotation.Annotation;

import annotations.ClasseExemplo;
import annotations.Tabela;

public class App {
    public static void main(String[] args) throws Exception {
        ClasseExemplo exemplo = new ClasseExemplo();
        String nome = exemplo.getClass().getAnnotation(Tabela.class).nomeDaTabela();
        System.out.println(nome);
    }
}
