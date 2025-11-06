package listaEncadeada;

public class ListaEncadeada {
    private Node head;
    private Node tail;
    private int tamanho;

    public ListaEncadeada() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public int size() {
        return tamanho;
    }

    public void addFirst(Node node) {
        Node _node = new Node(node.getValor());
        _node.setProximo(head);
        if (head != null) {
            head.setAnterior(_node);
        } else {
            tail = _node;
        }
        head = _node;
        tamanho += 1;
    }

    public void push(Node node) {
        Node _node = new Node(node.getValor());
        if (head == null) {
            head = _node;
            tail = _node;
        } else {
            _node.setAnterior(tail);
            tail.setProximo(_node);
            tail = _node;
        }
        tamanho += 1;
    }

    public Node pop() {
        if (tail == null) {
            return null;
        } else {
            Node _pop = new Node(tail.getValor());
            if (tamanho == 1) {
                head = null;
                tail = null;
            } else {
                _pop.setAnterior(tail.getAnterior());
                tail = tail.getAnterior();
                tail.setProximo(null);
            }
            tamanho -= 1;
            return _pop;
        }
    }

    public Node elementAt(int index) {
        if (index > tamanho) {
            return null;
        } else if (index == -1) {
            return tail;
        } else {
            Node atual = head;
            for(int i = 0; i < index; i++) {
                atual = atual.getProximo();
            }
            return atual;
        }
    }

    public void insert(int index, Node node) {
        Node inPositionElement = elementAt(index);
        Node anterior = inPositionElement.getAnterior();
        Node _node = new Node(node.getValor());
        if (anterior == null) {
            head = _node;
        } else {
            anterior.setProximo(_node);
            _node.setAnterior(anterior);
        }
        _node.setProximo(inPositionElement);
        inPositionElement.setAnterior(_node);
        tamanho += 1;
    }   

    public void remove(int index) {
        Node inPositionElement = elementAt(index);
        Node anterior = inPositionElement.getAnterior();
        Node proximo = inPositionElement.getProximo();
        if (anterior == null) {
            head = proximo;
        } else {
            anterior.setProximo(proximo);
        }
        if (proximo == null) {
            tail = anterior;
        } else {
            proximo.setAnterior(anterior);
        }
        tamanho -= 1;
    }

    @Override
    public String toString() {
        Node atual = head;
        String stringList = "[";
        while (atual != null) {
            stringList += String.valueOf(atual.getValor());
            atual = atual.getProximo();
            if (atual != null) {
                stringList += ", ";
            }
        }
        stringList += "]";
        return stringList;
    }

    public String reverseString() {
        String stringList = "[";
        Node atual = tail;
        while (atual != null) {
            stringList += atual.getValor();
            atual = atual.getAnterior();
            if (atual != null) {
                stringList += ", ";
            }
        }
        stringList += "]";
        return stringList;
    }

    public void printList() {
        System.out.println(toString());
    }

    public void printReverseList() {
        System.out.println(reverseString() + " *reverse");
    }
}
