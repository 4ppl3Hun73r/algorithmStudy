package y2021.nov;

// 주식
// https://leetcode.com/problems/maximum-subarray/
public class Solution1125 {
    public int maxSubArray(int[] nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        //         [4,-1,2,1]
        // dp[0] = -2 
        // dp[1] = -2 + 1 vs 1  = 1          -2+1 vs 1    
        // dp[2] =  1 - 3 vs -3 = -2         1 vs 1-3 vs -3  이전최대 vs 현재포함최대 vs 현재부터
        // dp[3] =  -2 + 4 vs 4 = 4 
        // dp[4] =  4 - 1 vs -1 = 3 
        // dp[5] =  3 + 2 vs 2  = 5
        // dp[6] =  5 + 1 vs 1  = 6  -> max 
        // dp[7] =  6 + -5 vs -5  = 1
        // dp[8] =  1 + 4 vs 4 = 5
        /* 
           1, 2, 3, -5, 7, 10
           [5,4,-1,7,8]
           dp[0] = 5 or 0 + 0
           dp[1] = dp[0] + 4 or 0 + 4
           dp[2] = dp[1] + -1 or 0 + -1
           dp[3] = dp[2] + 7 or 0 + 7
           dp[4] = dp[3] + 8 or 0 + 8
        // 
        // 6
        DP
        */ 

        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}
