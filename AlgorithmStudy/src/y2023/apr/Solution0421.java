package y2023.apr;

import java.util.Arrays;

// https://leetcode.com/problems/profitable-schemes/
public class Solution0421 {

    // 어렵네... 답보고 제출.

    int[][][] memo = new int[101][101][101];
    int mod = (int) (1e9) + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        for (int i = 0; i <= group.length; i++) {
            for(int j = 0; j <= n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return find(0, 0, 0, n, minProfit, group, profit);
    }

    int find(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
        if (pos == group.length) {
            return profit >= minProfit ? 1 : 0;
        }

        if (memo[pos][count][profit] != -1) {
            return memo[pos][count][profit];
        }

        int totalWays = find(pos + 1, count, profit, n, minProfit, group, profits);
        if (count + group[pos] <= n) {
            totalWays += find(pos + 1, count + group[pos], Math.min(minProfit, profit + profits[pos]), n, minProfit, group, profits);
        }

        return memo[pos][count][profit] = totalWays % mod;
    }
}
