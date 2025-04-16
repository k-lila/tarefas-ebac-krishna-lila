import annotations.ClasseExemplo;
import annotations.Tabela;

public class App {
    public static void main(String[] args) throws Exception {
        // ClasseExemplo exemplo = new ClasseExemplo();
        // String nomeTabela = exemplo.getClass().getAnnotation(Tabela.class).nomeDaTabela();
        Class<ClasseExemplo> exemplo = ClasseExemplo.class;
        String nomeTabela = exemplo.getAnnotation(Tabela.class).nomeDaTabela();
        System.out.println(nomeTabela);
    }
}
