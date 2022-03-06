package y2022.mar;

// https://leetcode.com/problems/delete-and-earn/
public class Solution0305 {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];

        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] += nums[i];
        }

        for (int i = 2; i < 10001; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }

        return dp[10000];

    }
}
