package y2022.sep;

// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
public class Solution0923 {
    public int concatenatedBinary(int n) {

        int mod = 1000000007;
        long ans = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                len++;
            }
            ans = ((ans << len) | i) % mod;
        }

        return (int)ans;

    }
}
