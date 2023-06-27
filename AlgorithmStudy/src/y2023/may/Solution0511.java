package y2023.may;

// https://leetcode.com/problems/uncrossed-lines/
public class Solution0511 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        /*
        서로 침범하지 않고 그을 수 있는 최대의 선의 수를 반환
         */

        /*
        nums1[i] == nums2[j] => answer = 1 + dfs(i + 1, j + 1)
        dp[i][j] = i 에서 j 까지의 최대 값
         */

        int n1 = nums1.length;
        int n2 = nums2.length;

        Integer[][] dp = new Integer[n1 + 1][n2 + 1];

        return dfs(nums1, nums2, n1, n2, dp);
    }

    private int dfs(int[] nums1, int[] nums2, int n1, int n2, Integer[][] dp) {
        if (n1 <= 0 || n2 <= 0) {
            return 0;
        }

        if (dp[n1][n2] != null) {
            return dp[n1][n2];
        }

        if (nums1[n1 - 1] == nums2[n2 - 1]) {
            dp[n1][n2] = 1 + dfs(nums1, nums2, n1 - 1, n2 - 1, dp);
        } else {
            dp[n1][n2] = Math.max(dfs(nums1, nums2, n1 - 1, n2, dp),
                    dfs(nums1, nums2, n1, n2 - 1, dp));
        }

        return dp[n1][n2];
    }
}
