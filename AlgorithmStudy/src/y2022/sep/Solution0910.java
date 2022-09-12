package y2022.sep;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class Solution0910 {
    public int maxProfit(int k, int[] prices) {
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54117/Clean-Java-DP-solution-with-comment
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        if (k >= len / 2) {
            int maxProfit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }


        int[][] dp = new int[k + 1][len];

        for (int i = 1; i <= k ; i++) {
            int max = dp[i - 1][0] - prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
                max = Math.max(max, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][len - 1];
    }
}
