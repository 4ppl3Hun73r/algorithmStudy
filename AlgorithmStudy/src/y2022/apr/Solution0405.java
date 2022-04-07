package y2022.apr;

// https://leetcode.com/problems/container-with-most-water/
public class Solution0405 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left <= right) {
            maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);


            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
