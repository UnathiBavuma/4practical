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
     public void insert(String key, String value) {
        int i = hash(key);

        for (Entry e : table[i]) {
            if (e.key.equals(key)) {
                e.value = value;   // update if exists
                return;
            }
        }

        table[i].add(new Entry(key, value));
    }
     public String lookup(String key) {
        int i = hash(key);

        for (Entry e : table[i]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }

        return null;
    }
       public String remove(String key) {
        int i = hash(key);

        for (Entry e : table[i]) {
            if (e.key.equals(key)) {
                String val = e.value;
                table[i].remove(e);
                return val;
            }
        }

        return null;
    }
}


