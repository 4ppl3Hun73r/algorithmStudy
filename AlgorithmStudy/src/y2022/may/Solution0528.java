package y2022.may;


// https://leetcode.com/problems/missing-number/
public class Solution0528 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;

        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
