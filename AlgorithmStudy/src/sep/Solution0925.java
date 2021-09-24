package sep;

import java.util.HashMap;
import java.util.Map;

public class Solution0925 {


    Map<Integer, Integer> t = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        if (t.containsKey(n)) {
            return t.get(n);
        }
        int tr = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        t.put(n, tr);

        return tr;
    }
}
