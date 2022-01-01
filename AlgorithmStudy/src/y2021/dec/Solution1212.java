package y2021.dec;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/
public class Solution1212 {
    public boolean canPartition(int[] nums) {
        // [1, 5, 11, 5]
        /*
        dp[0] =
         */

        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        if (sum%2 != 0) {
            return false;
        }
        int half = sum / 2;
        if (max > half) {
            return false;
        }

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                    if (dp[half]) {
                        return true;
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1212 s = new Solution1212();

        s.canPartition(new int[]{1,5,11,5});
    }
}
