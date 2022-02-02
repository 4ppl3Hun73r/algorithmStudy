package y2022.feb;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Solution0201 {
    public int maxProfit(int[] prices) {

        int len = prices.length;

        // max(sell - buy) = max(prices[j] - prices[i]), i < j
        //

        int result = 0;
        int maxSellRight = prices[len - 1];
        for (int i = len - 2; i >= 0; i --) {
            result = Math.max(result, maxSellRight - prices[i]);
            maxSellRight = Math.max(maxSellRight, prices[i]);
        }

        return result;
    }
}
