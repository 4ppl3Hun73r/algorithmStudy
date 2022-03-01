package y2022.mar;

// https://leetcode.com/problems/counting-bits/
public class Solution0301 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        if (n > 0) {
            result[1] = 1;
        }
        int init = 2;
        int prev = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i == init) {
                init = init * 2;
                prev = prev * 2;
            }
            result[i] = result[i - prev] + 1;
        }
        return result;

    }
}
