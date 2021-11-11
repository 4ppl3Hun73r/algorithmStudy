package nov;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Solution1110 {

    public int maxProfit(int[] prices) {
        // 전에 풀었던거 oct.Solution1015.maxProfit (buy, sell, cooldown)
        // 가장 순이익이 많게 거래
        // 사고나서 당일에 팔지 못함
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = -prices[0]; // 사고
        dp[0][1] = 0; // 팔고
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
