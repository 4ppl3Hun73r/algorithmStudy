package y2022.sep;

import java.util.Arrays;

// https://leetcode.com/problems/sum-of-even-numbers-after-queries/
public class Solution0921 {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int num : nums) {
            if (isEven(num)) {
                evenSum += num;
            }
        }


        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            if (isEven(nums[idx])) {
                evenSum -= nums[idx];
            }
            nums[idx] += val;

            if (isEven(nums[idx])) {
                evenSum += nums[idx];
            }
            ans[i] = evenSum;
        }

        return ans;
    }

    private boolean isEven(int num) {
        return (num % 2) == 0;
    }

    public static void main(String[] args) throws Exception {
        Solution0921 s = new Solution0921();

        System.out.println(Arrays.toString(s.sumEvenAfterQueries(new int[]{-2, 2, -4, -5}, new int[][]{{-1, 0}})));
    }
}
