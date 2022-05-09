package y2022.may;

// https://leetcode.com/problems/sort-array-by-parity/
public class Solution0502 {
    public int[] sortArrayByParity(int[] nums) {
        /*
         모든 짝수가 앞에 먼저 나오고 그 다음에 홀수가 나오게 nums 를 재배열 하라
         */
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] % 2 == 1) {
                while (start < end) {
                    if (nums[end] % 2 == 0) {
                        int temp = nums[start];
                        nums[start] = nums[end];
                        nums[end] = temp;
                        break;
                    }
                    end--;
                }
            }
            start++;
        }

        return nums;
    }
}
