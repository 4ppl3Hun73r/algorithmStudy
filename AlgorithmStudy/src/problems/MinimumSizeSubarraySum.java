package problems;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        /*
        [2,3,1,2,4,3], target 7
                [4,3] -> 2
         */
        int ans = 0;
        int len = nums.length;
        int[] prefixSum = new int[len + 1];
        prefixSum[0] = nums[0];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));

        for (int i = 1; i < len; i++) {
            for (int j = i; j <= len; j++) {
                int sum = prefixSum[j] - prefixSum[j - i];
                if (sum >= target) {
                    return i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        MinimumSizeSubarraySum s = new MinimumSizeSubarraySum();

        //System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(s.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }


}
