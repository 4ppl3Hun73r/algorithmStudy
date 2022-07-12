package y2022.jul;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class Solution0710 {
    public int minCostClimbingStairs(int[] cost) {
        /*
        0 또는 1에서 시작 가능
        한번에 1칸 혹은 2칸 이동
        cost.length (마지막칸 다음) 까지 이동할때 최소값
         */

        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i], Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]));
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
