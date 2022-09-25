package y2022.sep;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class Solution0920 {
    public int findLength(int[] nums1, int[] nums2) {
        /*
        양쪽에 모두 나타는 가장 긴 subarray 를 찾아라

         */

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int ans = 0;

        for (int i = 1; i <= nums1.length; i++) {

            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }

        }

        return ans;

    }
}
