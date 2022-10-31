package y2022.oct;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
public class Solution1008 {
    public int threeSumClosest(int[] nums, int target) {
        // [-1,2,1,-4], target = 1
        // O(n3) -> 줄이는 방법?
        // O(nlogn) + O(n3) => o(n3)
        // O(nlogn) + O(nlogn) / O(n2) => O(n2)
        Arrays.sort(nums);

        // [-4, -1, 1, 2], 1
        // [a,  b,     c], 1 > -3 : diff : 4
        // [a,   ,  b, c], 1 > -1 : diff : 2
        // [ ,  a,  b, c], 1 < 2 : diff : 1 정답 "2";
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ib = i + 1;
            int ic = nums.length - 1;
            while (ib < ic) {
                int sum = nums[i] + nums[ib] + nums[ic];
                int sDiff = Math.abs(target - sum);
                if (sDiff < diff) {
                    diff = sDiff;
                    result = sum;
                }
                if (sDiff == 0) {
                    return sum;
                }
                if (target > sum) {
                    ib++;
                } else {
                    ic--;
                }
            }
        }

        return result;
    }
}
