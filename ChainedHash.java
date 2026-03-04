import java.util.LinkedList;

public class ChainedHash {
    static class Entry {
        String key, value;
        Entry(String k, String v) { key = k; value = v; }
    }

    private LinkedList<Entry>[] table;
    private int m;

    public ChainedHash(int m) {
        this.m = m;
        table = new LinkedList[m + 1];
        for (int i = 1; i <= m; i++)
            table[i] = new LinkedList<>();
    }
    
