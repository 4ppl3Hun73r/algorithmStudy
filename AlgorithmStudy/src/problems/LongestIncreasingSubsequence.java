package problems;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        int result = 1;
        for (int i = 0; i < len; i++) {
            int max = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                    dp[i] = max;
                }
            }
            result = Math.max(result, max);
        }
        return result;
    }

    public int lengthOfLISFail(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int result = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i + 1][j]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i + 1][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

}

/*
  dp[i][j] = i ~ j 사이에서 가장 긴 증가하는 subsequence
  dp[n][n] = 1
   0 1 2 3 4 5 6
  [0,3,1,6,2,2,7]
  dp[5][6] = (nums[5] < nums[6]) => min(dp[5][5], dp[6][6]) + 1 = 2
  dp[4][5] = (nums[4] = nums[5]) => max(dp[4][4], dp[5][5]) + 0 = 1
  dp[4][6] = (nums[4] < nums[6]) => min(dp[4][5], dp[5][6]) + 1 = 2
  dp[3][4] = (nums[3] > nums[4]) => max(dp[3][3], dp[4][4]) + 0 = 1
  dp[3][5] = (nums[3] > nums[5]) => max(dp[3][4], dp[4][5]) + 0 = 1
  dp[3][6] = (nums[3] < nums[7]) => min(dp[3][5], dp[4][6]) + 1 = 2
  dp[3][7] = (nums[3] < nums[7]) => min(dp[3][6], dp[4][6]) + 1 = 3
  dp[2][3] = (nums[2] < nums[3]) => min(dp[2][2], dp[3][3]) + 1 = 2
  dp[2][4] = (nums[2] < nums[4]) => min(dp[2][3], dp[3][4]) + 1 = 2
  dp[2][5] = (nums[2] < nums[5]) => min(dp[2][4], dp[3][5]) + 1 = 2
  dp[2][6] = (nums[2] < nums[6]) => min(dp[2][5], dp[3][6]) + 1 = 3
  dp[1][2] = (nums[1] > nums[2]) => max(dp[1][1], dp[2][2]) + 0 = 1
  dp[1][3] = (nums[1] < nums[3]) => min(dp[1][2], dp[2][3]) + 1 = 2
  dp[1][4] = (nums[1] > nums[4]) => max(dp[1][3], dp[2][4]) + 0 = 2
  dp[1][5] = (nums[1] > nums[5]) => max(dp[1][4], dp[2][5]) + 0 = 2
  dp[1][6] = (nums[1] < nums[6]) => min(dp[1][5], dp[2][6]) + 1 = 3
  dp[0][1] = (nums[0] < nums[1]) => min(dp[0][0], dp[1][1]) + 1 = 2
  dp[0][2] = (nums[0] < nums[2]) => min(dp[0][1], dp[1][2]) + 1 = 2
  dp[0][3] = (nums[0] < nums[3]) => min(dp[0][2], dp[1][3]) + 1 = 3
  dp[0][4] = (nums[0] < nums[4]) => min(dp[0][3], dp[1][4]) + 1 = 3
  dp[0][5] = (nums[0] < nums[5]) => min(dp[0][4], dp[1][5]) + 1 = 3
  dp[0][6] = (nums[0] < nums[6]) => min(dp[0][5], dp[1][6]) + 1 = 4

  잘 동작하는거 같은데 이거 아님 ㅠ

 */