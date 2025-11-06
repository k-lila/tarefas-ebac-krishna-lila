package fila;

public class FIFO {
    private int MAX_SIZE;
    private int[] elementos;
    private int primeiro;
    private int ultimo;
    private int tamanho;


    public FIFO(int maximo) {
        this.MAX_SIZE = maximo;
        this.elementos = new int[MAX_SIZE];
        this.primeiro = 0;
        this.ultimo = -1;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho <= 0;
    }

    public int size() {
        return tamanho;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("método front(): fila vazia");
        }
        return elementos[primeiro];
    }

    public int rear() throws Exception {
        if (isEmpty()) {
            throw new Exception("método rear(): fila vazia");
        }
        return elementos[ultimo];
    }

    public void enqueue(int novoElemento) throws Exception {
        if (tamanho == elementos.length) {
            throw new Exception("método enqueue(): fila cheia");
        }
        ultimo = (ultimo + 1) % MAX_SIZE;
        elementos[ultimo] = novoElemento;
        tamanho++;
    }

    public void dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("método dequeue(): fila vazia");
        }
        primeiro = (primeiro + 1) % MAX_SIZE;
        tamanho--;
    }

    @Override
    public String toString() {
        String _string = "[";
        for (int i = 0; i < tamanho; i++) {
            int index = (primeiro + i) % MAX_SIZE;
            _string += elementos[index];
            if (i != tamanho - 1) {
                _string += ", ";
            }
        }
        _string += "]";
        return _string;
    }
}
