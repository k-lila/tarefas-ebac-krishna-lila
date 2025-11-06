package pilha;

public class Pilha {
    private int[] elementos;
    private int controledSize;

    public Pilha(int maximo) {
        this.elementos = new int[maximo];
        this.controledSize = 0;
    }

    public int size() {
        return controledSize;
    }

    public boolean isEmpty() {
        return controledSize <= 0;
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("método top(): pilha vazia");
        }
        return elementos[controledSize - 1];
    }

    public void push(int novoElement) throws Exception {
        if (controledSize == elementos.length) {
            throw new Exception("método push(): pilha cheia");
        }
        elementos[controledSize] = novoElement;
        controledSize += 1;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("método pop(): pilha vazia");
        } else {
            controledSize -= 1;
            return elementos[controledSize];
        }
    }

    @Override
    public String toString() {
        String _string = "[";
        for (int i = 0; i < controledSize; i++) {
            _string += elementos[i];
            if (i != controledSize -1) {
                _string += ", ";
            }
        }
        _string += "]";
        return _string;
    }

}
