package y2022.oct;

// https://leetcode.com/problems/set-mismatch/
public class Solution1023 {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int loss = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                loss = i + 1;
            }
        }

        return new int[]{dup, loss};
    }
}
