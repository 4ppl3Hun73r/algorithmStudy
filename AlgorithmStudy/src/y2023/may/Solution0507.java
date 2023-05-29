package y2023.may;

// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
public class Solution0507 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        int[] ans = new int[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            int height = obstacles[i];

            int idx = helper(obstacles, height, right);
            if (idx == right) {
                right++;
            }
            obstacles[idx] = height;
            ans[i] = idx + 1;
        }

        return ans;

    }


    private int helper(int[] obstacles, int target, int right) {
        if (right == 0) {
            return 0;
        }

        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (obstacles[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
