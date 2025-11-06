package tests;

import listaEncadeada.ListaEncadeada;
import listaEncadeada.Node;

public class ListaEncadeadaTests {
    private ListaEncadeada listaEncadeada;
    public ListaEncadeadaTests() {
        this.listaEncadeada = new ListaEncadeada(); 
    }

    private void printLists() {
        listaEncadeada.printList();
        listaEncadeada.printReverseList();
        System.out.println("size: " + listaEncadeada.size());
        System.out.println("-");
    }

    public void test() throws Exception {
        printLists();
        System.out.println("# addFirst()");
        listaEncadeada.addFirst(new Node(1));
        listaEncadeada.addFirst(new Node(2));
        listaEncadeada.addFirst(new Node(3));
        printLists();
        System.out.println("# push()");
        listaEncadeada.push(new Node(4));
        listaEncadeada.push(new Node(5));
        printLists();
        Node pop = listaEncadeada.pop();    
        System.out.println("pop valor: " + pop.getValor());
        System.out.println("pop anterior: " + (pop.getAnterior() != null ? pop.getAnterior().getValor() : "null"));
        System.out.println("pop próximo: " + (pop.getProximo() != null ? pop.getProximo().getValor() : "null"));
        printLists();
        int index = 0;
        int insert = 0;
        Node byIndex = listaEncadeada.elementAt(index);
        System.out.println("index " + index + ": " + byIndex.getValor());
        listaEncadeada.insert(index, new Node(0));
        System.out.println("insert " + insert + " no index " + index);
        System.out.println("index " + index + ": " + listaEncadeada.elementAt(index).getValor());
        printLists();
        System.out.println("remover o index " + index);
        listaEncadeada.remove(index);
        printLists();
    }
}
