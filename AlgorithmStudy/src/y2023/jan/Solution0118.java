package y2023.jan;

// https://leetcode.com/problems/maximum-sum-circular-subarray/
public class Solution0118 {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        // dp[i] -> i 까지의 가장 큰 배열 합
        // dp[i + 1] = max(dp[i], 0) + nums[i + 1];

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }


        // array = [---------]
        // circular array = [---------][---------]
        // max sub array = [----max---]
        // max sub array(circular) = [---------ma][x--------]
        // max sub array(circular, in array) = [ma-------x] => [ma[min subarray]x] => total - min subarray == max subarray
        int min = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.min(dp[i - 1] + nums[i], nums[i]);
            min = Math.min(min, dp[i]);
        }

        int max = nums[0];
        dp = new int[len + 1];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        if (total == min) {
            return max;
        }

        return Math.max(total - min, max);
    }
}
