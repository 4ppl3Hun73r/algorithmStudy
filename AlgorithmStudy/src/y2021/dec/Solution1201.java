package y2021.dec;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/
public class Solution1201 {
    public int rob(int[] nums) {
        // 집을 털어야 하는데 하루는 쉬어야함 -> 이틀 연속으로만 안 털면됨.
        // DP / DP

        int len = nums.length;
        int[][] dp = new int[len][2];

        dp[0][0] = nums[0]; // 훔치기
        dp[0][1] = 0; // 쉬고
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Arrays.deepToString(dp));
        /*
        1, 2, 3, 1
        1, 2, 4, 3
        0, 1, 2, 4
         */

        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int rob2(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for(int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
            System.out.println(Arrays.toString(dp));

            // i + 1 -> 쉬었을때
            // i + 2 -> 털었을때
        }
        return dp[0];
    }

    public static void main(String[] args) throws Exception {
        Solution1201 s = new Solution1201();
        System.out.println(s.rob2(new int[]{1,2,3,1})); // 4
        //System.out.println(s.rob(new int[]{2,7,9,3,1})); // 12

    }
}
