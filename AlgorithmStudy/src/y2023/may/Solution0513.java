package y2023.may;

// https://leetcode.com/problems/count-ways-to-build-good-strings/
public class Solution0513 {
    int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        /*
        0 과 1을 조합해서 low <= numStr.length <= high 를 만족시키는 모든  조합
        단 0을 붙이려면 한번에 zero 개, 1을 붙이려면 한번에 one 개를 붙여야 한다. (2진수임)

        zero = 1, one = 2

        low 2
            00
            000

            11
            011
            110
        high 3



        */
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int end = 1; end <= high; end++) {
            if (end >= zero) {
                dp[end] += dp[end - zero];
            }
            if (end >= one) {
                dp[end] += dp[end - one];
            }
            dp[end] %= mod;
        }

        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dp[i];
            ans %= mod;
        }
        return ans;
    }
}
