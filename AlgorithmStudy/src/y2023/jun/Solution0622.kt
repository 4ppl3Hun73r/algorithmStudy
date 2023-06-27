package y2023.jun

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
class Solution0622 {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        /*
         prices : [1,3,2,8,4,9] , fee = 2

         (9 - 1 - 2) + (8 - 2 - 2) =

            8 - 1 - 2 = 5
            9 - 4 - 2 = 3

            buy = gold - prices[i]
            sell =

            buy  : max(전날 샀을때, 전날 팔았을때 값 - 현재가격)
            sell : max(전날 팔았을때, 저날 샀을때 값 + 현재가격 - fee)


            buy : [-1,-1, 0, 0, 4,  4]
           sell : [ 0, 2, 2, 8, 8, 13]
         */
        var buy = -prices[0]
        var sell = 0

        for(i in 1 until prices.size) {
            buy = buy.coerceAtLeast(sell - prices[i])
            sell = sell.coerceAtLeast(buy + prices[i] - fee)
        }

        return sell
    }
}
