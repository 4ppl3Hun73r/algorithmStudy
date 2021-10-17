package problems;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(prices[j] - prices[i], result);
            }
        }

        // DP, ~~Doble Pointer~~
        int len = prices.length;
        result = 0;
        int maxRight = prices[len - 2];
        for (int i = len - 2; i >= 0; i --) {
            result = Math.max(result, maxRight - prices[i]);
            maxRight = Math.max(maxRight, prices[i]);
        }

        return result;
    }
}

/*
 * [2,3,7,3,1,4], 5
 *          ^ ^   : 3
 *        ^   ^   : 1
 *      ^     ^   : 3
 *    ^ ^         : 4
 *  ^   ^         : 5
 *
 * dp[0][buy] = -2
 * dp[0][sell] = 0
 *
 * dp[1][buy] = min(dp[0][buy], price[1])
 * dp[1][sell] = dp[0][buy] + 3 = 1
 *
 * dp[2][buy] = min(dp[1][buy], price[2])
 * dp[2][sell] = dp[1][buy] + 7 = 1
 *
 * i len -> 0
 * dp[i] = max(dp[i + 1], maxRight - price[i]) == result = max(result, maxRight - price[i])
 * dp[i - 1] = max(dp[i], maxRight - price[i - 1])
 * [5,4,3,3,3]
 *
 */