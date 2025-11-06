package hashmap;

public class HashMapInternalList {
    private Node head;
    private Node tail;

    public static class Node {
        public int key;
        public int value;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashMapInternalList() {
        this.head = null;
        this.tail = null;
    }

    public void push(int key, int value) {
        Node _node = new Node(key, value);
        if (head == null) {
            head = _node;
            tail = _node;
        } else {
            tail.next = _node;
            tail = _node;
        }
    }

    public Integer get(int key) {
        Node atual = head;
        while (atual != null) {
            if (atual.key == key) {
                return atual.value;
            };
            atual = atual.next;
        }
        return null;
    }

    public void remove(int key) {
        Node toDelete = head;
        Node previous = null;
        while (toDelete != null) {
            if (toDelete.key == key) {
                if (previous == null) {
                    head = toDelete.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    previous.next = toDelete.next;
                    if (toDelete == tail) {
                        tail = previous;
                    }
                }
                return;
            };
            previous = toDelete;
            toDelete = toDelete.next;
        }
    }

    @Override
    public String toString() {
        String _string = "[";
        Node atual = head;
        while (atual != null) {
            _string += "{" + atual.key + ": " + atual.value + "}";
            atual = atual.next;
            if (atual != null) {
                _string += ", ";
            }
        }
        _string += "]";
        return _string;
    }

}
