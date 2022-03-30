package y2022.mar;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class Solution0328 {
    public boolean search(int[] nums, int target) {
        /*
         0 0 0 0 0 0 1 2 3 0

         0 0 0 0 0 0 1 0 0 0

         0 0 0 0 0 0 0 0 0 1

         0 0 0 0 0 1 1 1 1 0

         0 0 1 0 0 0 0 0 0 0

         */
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start < end) {
            int m = (start + end) / 2;
            int mid = nums[m];
            if (mid == target) {
                return true;
            }

            // 0 1 2 3 4 5 0 0 0
            // s       m       e
            if (mid < nums[end] || mid < nums[start]) {
                if (target > mid && target <= nums[end]) {
                    // 8 8 8 8 4 5 5 5 8, target 8
                    start = m + 1;
                } else {
                    // 0 1 2 3 4 5 0 0 0, target 3
                    end = m - 1;
                }
            // 0, 1, 2, 3, 4, 5, 0, 0
            } else if (mid > nums[start] || mid > nums[end]) {
                if (target < mid && target >= nums[start]) {
                    // 0, 0, 1, 3, 0, 0, 0
                    end = m - 1;
                } else {
                    // 6, 7, 8, 1, 3, 4, 5
                    start = m + 1;
                }
            } else {
                // 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 -> s, m, e 가 다 같을때
                end--;
            }
        }

        return false;
    }
}
