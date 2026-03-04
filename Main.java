import java.util.*;

public class Main {
    static final int N = 1 << 20; // 2^20
    static final int REP = 30;

    public static void main(String[] args) {
        String[] keys = new String[N];
        for (int i = 0; i < N; i++)
            keys[i] = String.valueOf(i + 1);