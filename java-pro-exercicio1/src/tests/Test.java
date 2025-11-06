package tests;

public class Test {
    private void title(String title) {
        title = " ".repeat(15) + title + " ".repeat(15);
        String _string = "_".repeat(title.length()) + "\n\n" + title + "\n" + "_".repeat(title.length()) + "\n";
        System.out.println(_string);
    }

    public void show() throws Exception {
        title("# testes da classe Pilha.java");
        PilhaTests pilhaTests = new PilhaTests();
        pilhaTests.test();

        title("# testes da classe FIFO.java #");
        FIFOTests fifoTests = new FIFOTests();
        fifoTests.test();

        title("testes da classe ListaEncadeada.java");
        ListaEncadeadaTests listaEncadeadaTests = new ListaEncadeadaTests();
        listaEncadeadaTests.test();

        title("testes da classe HashMap.java");
        HashMapTest hashMapTest = new HashMapTest();
        hashMapTest.test();
    }
    
}
