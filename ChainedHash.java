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