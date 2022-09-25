package y2022.sep;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
public class Solution0916 {
    public int maximumScoreFail(int[] nums, int[] multipliers) {
        /*
        n >= m
        nums 의 앞뒤에서 수를 하나 선택
        multipliers 는 앞에서 부터 선택됨
        nums[x] * multipliers[i] 의 합이 가장 크게 되는 score 를 반환

        greedy?
       n[2,2,1,-2,1]
       m[10,-10,10,10]

        20, -10, 10
        10 -2*-10
        20 -10

        dp[nums.len][multipliers.len - 1];
        dp[i]


              [1][2][3][4]  - nums
             0 0  0  0  0  0
         [3] 0 3  0  0  12
         [2] 0 2
         [1] 0 14         0
          m
         */
        int score = 0;
        int[][] dp = new int[multipliers.length + 1][nums.length + 2];

        for (int i = 1; i <= multipliers.length; i++) {
            int mul = multipliers[i - 1];

            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1]) + (mul * nums[j - 1]);
            }
            for (int j = nums.length; j > nums.length - i; j--) {
                if (j - 1 < i) {

                }
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1]) + (mul * nums[j - 1]);
            }
            System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));
        }

        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        return score;

    }

    public int maximumScoreTopDown(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int op = m - 1; op >= 0; op--) { // 뒤에서 부터?
            for (int left = op; left >= 0; left--) { // 왼쪽에서 계산
                dp[op][left] = Math.max(multipliers[op] * nums[left] + dp[op + 1][left + 1],
                        multipliers[op] * nums[n - 1 - (op - left)] + dp[op + 1][left]);
            }
        }

        return dp[0][0];
    }

    public int maximumScore2(int[] nums, int[] multipliers) {

        int N = nums.length, M = multipliers.length;

        return helper(nums, multipliers, 0, N - 1, new Integer[M][M]);
    }

    private int helper(int[] nums, int[] multipliers, int i, int j, Integer[][] dp) {

        int N = nums.length, M = multipliers.length;
        int index = (i - 0) + (N - 1 - j);
        if (index == M) return 0;

        if (dp[i][j - (N - M)] != null) return dp[i][j - (N - M)];

        int res = Math.max(nums[i] * multipliers[index] + helper(nums, multipliers, i + 1, j, dp),
                nums[j] * multipliers[index] + helper(nums, multipliers, i, j - 1, dp));

        return dp[i][j - (N - M)] = res;
    }

    public static void main(String[] args) throws Exception {
        Solution0916 s = new Solution0916();

        System.out.println(s.maximumScoreTopDown(new int[]{1,2,3,4}, new int[]{3,2,1}));
    }
}
