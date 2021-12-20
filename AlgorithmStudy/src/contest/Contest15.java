package contest;

import java.util.HashMap;
import java.util.Map;

public class Contest15 {
    Map<Long, Long> cache = new HashMap<>();

    public long getDescentPeriods(int[] prices) {
        long result = 0;
        int c = 1;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] - prices[i + 1] == 1) {
                c++;
            } else {
                result += sum(c);
                c = 1;
            }
        }
        result += sum(c);

        return result;
    }

    private long sum(long n) {
        if (n == 1) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long r = n + sum(n - 1);
        cache.put(n, r);

        return r;
    }

    public static void main(String[] args) {
        Contest15 c = new Contest15();

        System.out.println(c.getDescentPeriods(new int[]{3,2,1,4}));
        System.out.println(c.getDescentPeriods(new int[]{8,6,7,7}));
        System.out.println(c.getDescentPeriods(new int[]{1}));
        System.out.println(c.getDescentPeriods(new int[]{3,2,1,4,3,2,1,1,5,4,3,2,1}));

        for (int i = 100000; i >= 0; i--) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
