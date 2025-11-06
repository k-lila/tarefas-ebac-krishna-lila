package tests;

import fila.FIFO;

public class FIFOTests {
    private FIFO fifo;

    public FIFOTests() {
        this.fifo = new FIFO(10);
    }

    public void info() {
        String _string = fifo.toString() + " | tamanho: " + fifo.size() + " | vazia: " + fifo.isEmpty();
        System.out.println(_string);
        System.out.println("-");
    }

    public void test() throws Exception {
        info();
        System.out.println("# enqueue 5x");
        fifo.enqueue(1);
        fifo.enqueue(2);
        fifo.enqueue(3);
        fifo.enqueue(4);
        fifo.enqueue(5);
        info();
        System.out.println("# front: " + fifo.front());
        System.out.println("# rear: " + fifo.rear());
        System.out.println("-");
        System.out.println("# dequeue 2x");
        fifo.dequeue();
        fifo.dequeue();
        info();
        fifo.enqueue(1);
        fifo.enqueue(2);
        info();
    }

}
