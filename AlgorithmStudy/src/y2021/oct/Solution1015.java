package y2021.oct;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class Solution1015 {
    public int maxProfit(int[] prices) {
        // Array, DP
        // 주식을 사고 팔고 쉬고

        // [ buy, buy .... ] -> X
        // [ buy, sell ]
        // [ N/A, buy, N/A ]
        // [ sell, cooldown, buy ]
        // [ buy, N/A, N/A, sell, cooldown ]
        // stock 무조건 하나만 들고 있어야 하고
        // [ 100, 1, 0, 0, 100, 1]
        // [ N/A, N/A, buy, N/A, sell, cooldown] -> 최대 이익
        /*
        * dp[X][i] = 프로핏(잔액)
        * [buy, null, sell, cooldown, buy]
        *
        * i-1 (i-2/i-3)
        *
        * dp[i][주식의가격] =
        * dp[사고][i] = Math.max(dp[팔고][i - 1] - prices[i], dp[사고][i - 1])
        * dp[팔고][i] = Math.max(dp[
        *
        * dp[사고][i] = 저번거를 파
        *
        * 최대 프로핏 = Math.max(dp[사고][i], dp[팔고][i])
        *
        * dp[0][사고] = -7
        * dp[0][팔고] = 0
        *
        * dp[1][사고] = Math.max(0 - 1, -7) : -1
        * dp[1][팔고] = Math.max(-7, 1) : 1
        *
        *
        * dp[i][B/S/C]
        * dp[i][B] = 구매한 상태
        * dp[i][S] = 판매한 상태
        *
        *  [B ,S , C,B,S]
        *  [1 ,2 , 3,0,2], 3
        * B[-1,-1,-1,1,1] -> Max(C[i - 1] - prices[i]사거나, B[i - 1]아무것나 안하거나)
        * S[0 , 1, 2,2,3] -> Max(B[i - 1] + prices[i]팔거나, S[i - 1]아무것도 안하거나)??
        * C[0 , 0, 1,2,2] -> Max(S[i - 1], C[i - 1]아무것도 안하거나)??
        *
        *
        * [-7,-1,0,0,0,0]
        * [0,0,0,0,0,0]
        * */

        // [1,2,3,0,2]
        // [buy, sell, cooldown, buy, sell]
        int len = prices.length;
        int[][] dp = new int[len][3];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[len - 1][0], Math.max(dp[len - 1][1], dp[len - 1][2]));
    }

    public int maxProfit2(int[] prices) {
        int[] dp = new int[prices.length + 2];
        int p1 = prices[prices.length - 1] + dp[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            p1 = Math.max(p1, prices[i + 1] + dp[i + 3]);
            dp[i] = Math.max(dp[i + 1], p1 - prices[i] );
        }
        return dp[0];
    }

    public int maxProfit3(int[] prices) {
        // 3개
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;
        for (int price : prices) {
            int oldRest = rest;
            rest = Math.max(rest, sold);
            sold = hold + price; // ?
            hold = Math.max(hold, oldRest - price);
        }
        return Math.max(rest, sold);
    }
}
