package problems;

import java.util.Arrays;

// https://leetcode.com/problems/largest-perimeter-triangle/
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        // 삼각형의 조건 a + b > c
        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        return 0;

    }
}
