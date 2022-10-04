package y2022.oct;

// https://leetcode.com/problems/decode-ways/
public class Solution1001 {

    public int numDecodings(String s) {
        // 'A' -> 1
        // 'B' -> 2
        // 'Z' -> 26

        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= len; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));

            if (one >= 1 && one <= 9) {
                dp[i] += dp[i-1];
            }
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[len];
    }
}
