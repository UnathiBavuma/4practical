import java.util.*;

public class Main {
    static final int N = 1 << 20; // 2^20
    static final int REP = 30;

    public static void main(String[] args) {
        String[] keys = new String[N];
        for (int i = 0; i < N; i++)
            keys[i] = String.valueOf(i + 1);
            List<String> list = Arrays.asList(keys);
        Collections.shuffle(list);

        int[] loads = {75, 80, 85, 90, 95};

        System.out.println("Load\tOpen(s)\tChained(s)");

        for (int load : loads) {
            int used = (int)(950000 * (load / 100.0));
            int m = used;

            double openTime = 0, chainTime = 0;
            for (int r = 0; r < REP; r++) {

                OpenHash open = new OpenHash(m);
                ChainedHash chain = new ChainedHash(m);

                for (int i = 0; i < used; i++) {
                    open.insert(keys[i], keys[i]);
                    chain.insert(keys[i], keys[i]);
                }

                long t1 = System.currentTimeMillis();
                for (int i = 0; i < used; i++)
                    open.lookup(keys[i]);
                long t2 = System.currentTimeMillis();
                openTime += (t2 - t1);

