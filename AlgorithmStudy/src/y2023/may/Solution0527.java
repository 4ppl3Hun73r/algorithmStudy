package y2023.may;

// https://leetcode.com/problems/stone-game-iii/
public class Solution0527 {
    public String stoneGameIII(int[] stoneValue) {
        /*
        한번에 1 ~ 3개 까지 가져 올 수 있음
        모두 최적의 값을 가져올 거임

        누가 이길까?

        1 <= stoneValue.length <= 5 * 100000
        모두 탐색?
        */

        int n = stoneValue.length;
        Integer[] memo = new Integer[n];
        int aliceScore = dfs(stoneValue, 0, memo);

        if (aliceScore < 0) {
            return "Bob";
        }
        if (aliceScore > 0) {
            return "Alice";
        }

        return "Tie";
    }


    private int dfs(int[] stoneValue, int idx, Integer[] memo) {
        if (idx == stoneValue.length) {
            return 0;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        int result = stoneValue[idx] - dfs(stoneValue, idx + 1, memo); // 내가 뽑고 상태가 뽑은건 빼고
        if (idx + 2 <= stoneValue.length) {
            result = Math.max(result, stoneValue[idx] + stoneValue[idx + 1] - dfs(stoneValue, idx + 2, memo)); // 내가 2개 뽑고 상대가 뽑고
        }
        if (idx + 3 <= stoneValue.length) {
            result = Math.max(result, stoneValue[idx] + stoneValue[idx + 1] + stoneValue[idx + 2] - dfs(stoneValue, idx + 3, memo)); // 내가 3개 뽑고 상대가 뽑고
        }

        return memo[idx] = result;
    }
}
