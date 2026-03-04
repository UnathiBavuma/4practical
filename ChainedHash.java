import java.util.LinkedList;

public class ChainedHash {

    static class Entry {
        String key;
        String value;

        Entry(String k, String v) {
            key = k;
            value = v;
        }
    }
     private LinkedList<Entry>[] table;
    private int m;

    @SuppressWarnings("unchecked")
    public ChainedHash(int m) {
        this.m = m;
        table = new LinkedList[m + 1];   // create array

        for (int i = 1; i <= m; i++) {
            table[i] = new LinkedList<>();  // initialize each list
        }
    }

    private int hash(String key) {
        return (Math.abs(key.hashCode()) % m) + 1;
    }
