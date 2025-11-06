package tests;

import pilha.Pilha;

public class PilhaTests {
    private Pilha pilhaTest;
    public PilhaTests() {
        pilhaTest = new Pilha(5);
    }

    public void info() {
        System.out.println("pilha: " + pilhaTest.toString() + " | tamanho: " + pilhaTest.size() + " | vazia: " + pilhaTest.isEmpty());
        System.out.println("-");
    }

    public void test() throws Exception {
        info();
        System.out.println("# push");
        for (int i = 0; i < 5; i++) {
            pilhaTest.push(i + 1);
        }
        info();
        int pop = pilhaTest.pop();
        System.out.println("# pop: " + pop);
        info();
        int top = pilhaTest.top();
        System.out.println("# top: " + top);
        info();
    }
}
