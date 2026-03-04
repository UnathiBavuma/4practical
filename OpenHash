public class OpenHash {
    static class Entry {
        String key, value;
        Entry(String k, String v) { key = k; value = v; }
    }
    private Entry[] table;
    private int m, size = 0;

    public OpenHash(int m) {
        this.m = m;
        table = new Entry[m + 1]; // 1..m
    }

    private int hash(String key) {
        return (Math.abs(key.hashCode()) % m) + 1;
    }
     public boolean isFull() { return size == m; }
    public boolean isEmpty() { return size == 0; }

    public void insert(String key, String value) {
        int i = hash(key);
        while (table[i] != null && !table[i].key.equals(key))
            i = (i % m) + 1; // linear probing

        if (table[i] == null) size++;
        table[i] = new Entry(key, value);
    }
    public String lookup(String key) {
        int i = hash(key);
        while (table[i] != null) {
            if (table[i].key.equals(key))
                return table[i].value;
            i = (i % m) + 1;
        }
        return null;
    }
     public String remove(String key) {
        int i = hash(key);
        while (table[i] != null) {
            if (table[i].key.equals(key)) {
                String val = table[i].value;
                table[i] = null;
                size--;
                return val;
            }
            i = (i % m) + 1;
        }
        return null;
    }
}
