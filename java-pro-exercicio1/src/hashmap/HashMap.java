package hashmap;

public class HashMap {
    private final int MAX_SIZE = 10;
    private HashMapInternalList[] internalList;

    public HashMap() {
        this.internalList = new HashMapInternalList[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            this.internalList[i] = new HashMapInternalList();
        }
    }

    private int hash(int key) {
        int primo = 997;
        return (key * primo) % MAX_SIZE;
    }

    public void put(int key, int value) throws Exception {
        if (get(key) != null) {
            throw new Exception("\ncausa: KEY duplicada");
        } 
        internalList[hash(key)].push(key, value);
    }

    public Integer get(int key) {
        return internalList[hash(key)].get(key);
    }

    public void delete(int key) {
        if (get(key) != null) {
            internalList[hash(key)].remove(key);
        }
    }

    public void clear() {
        for (int i = 0; i < MAX_SIZE; i++) {
            this.internalList[i] = new HashMapInternalList();
        }
    }

    @Override
    public String toString() {
        String _string = "[\n";
        for (int i = 0; i < MAX_SIZE; i++) {
            _string += "    " + internalList[i].toString();
            if (i < MAX_SIZE - 1) {
                _string += ", \n";
            }
        }
        _string += "\n]";
        return _string;
    }

}
