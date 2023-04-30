package y2023.apr;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
public class Solution0415 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        /*
        dp[i][k] = i 번째 piles에서 k 개 뽑았을때 최대 값
        dp[i][k] = Math.max(dp[i][k - 1] + piles[i][k], ..); -> 이런식
         */

        int numberOfPiles = piles.size();
        int[][] dp = new int[numberOfPiles + 1][k + 1];

        for (int i = 0; i <= numberOfPiles; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(dp, piles, numberOfPiles, k);
    }

    private int dfs(int[][] dp, List<List<Integer>> piles, int n, int k) {
        if (n == 0) {
            return 0;
        }

        if (dp[n][k] != -1) {
            return dp[n][k];
        }

        int currentSum = 0;
        List<Integer> pile = piles.get(n - 1);
        int loopIdx = Math.min(pile.size() - 1, k);
        for (int i = 0; i <= loopIdx; i++) {
            if (i > 0) { // 내 pile 에서 뽑으면 currentSum에 더해주기
                currentSum += pile.get(i - 1);
            }
            ///dp[n][k] = Math.max(dp[n][k], dfs(dp, piles, n - 1, k - 1)); // 옆에 pile 에서 (k - 1) 을 뽑았을 때 와 비교, dfs 로 타고 가면서 그 옆에 그 옆에로 내려가면서 결국 모든 Piles에서 1개씩 뽑은 것도 결과로 넘어옴
            dp[n][k] = Math.max(dp[n][k], dfs(dp, piles, n - 1, k - i) + currentSum);
        }

        return dp[n][k];
    }
}
