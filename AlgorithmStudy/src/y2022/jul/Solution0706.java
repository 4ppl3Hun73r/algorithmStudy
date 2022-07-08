package y2022.jul;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fibonacci-number/
public class Solution0706 {

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int n1 = fib(n - 1);
        int n2 = fib(n - 2);

        cache.put(n - 1, n1);
        cache.put(n - 2, n2);

        return n1 + n2;
    }
}
