package structure;

abstract class HashTable {
    protected String REMOVED_FLAG = "[REMOVED]";
    protected int MAX_CAPACITY = 32;
    protected int capacity = 8;
    protected long collisions = 0;
    protected double loadFactor = 0.75;
    protected long count = 0;

    protected String[] table;

    public HashTable() {
        table = new String[capacity];
    }

    abstract int hash(String key);

    public void insert(String key) {
        if ((double) count / capacity >= loadFactor && capacity < 32) {
            resize();
        }

        int pos = hash(key);

        if (table[pos] != null && !table[pos].equals(REMOVED_FLAG)) {
            collisions++;

            for (int i = ++pos; i < capacity; i++) {
                if (table[i] == null || table[i].equals(REMOVED_FLAG)) {
                    pos = i;
                    break;
                }
            }
        }

        table[pos] = key;
        count++;
    }

    public boolean search(String key) {
        int pos = hash(key);

        if (!table[pos].equals(key)) {
            for (int i = ++pos; i < capacity; i++) {
                if (table[i] == null) {
                    return false;
                } else if (table[i].equals(key)) {
                    return true;
                }
            }
        }
        return true;
    }

    public boolean remove(String key) {
        int pos = hash(key);

        if (!table[pos].equals(key)) {
            for (int i = ++pos; i < capacity; i++) {
                if (table[i] == null) {
                    return false;
                } else if (table[i].equals(key)) {
                    pos = i;
                    break;
                }
            }
        }

        table[pos] = REMOVED_FLAG;
        return true;
    }

    private void resize() {
        String[] copy = table.clone();

        capacity += 8;
        table = new String[capacity];

        for (String key : copy) {
            if (key != null && !key.equals(REMOVED_FLAG)) {
                insert(key);
            }
        }
    }
}
