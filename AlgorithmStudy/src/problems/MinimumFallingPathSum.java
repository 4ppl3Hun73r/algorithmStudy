package problems;


import java.util.Arrays;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        // 반대로 찾아야 하나?
        /*
        [[2,1,3],
         [6,5,4],
         [7,8,9]]
         */

        // N개 중 하나 픽, N개중 하나 픽

        // dp[col][row] = matrix[col][row] + min(dp[row - 1][col], matrix[row - 1][col - 1], matrix[row - 1][col + 1])
        // dp[n + 1] = min(dp[

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i ++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                int a = Integer.MAX_VALUE;
                int b = dp[i - 1][j];
                int c = Integer.MAX_VALUE;
                if (j != 0) a = dp[i - 1][j - 1];
                if (j != col - 1) c = dp[i - 1][j + 1];

                dp[i][j] = matrix[i][j] + Math.min(a, Math.min(b, c));
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            result = Math.min(result, dp[row - 1][i]);
        }
        //System.out.println(Arrays.deepToString(dp));

        return result;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum d = new MinimumFallingPathSum();
        d.minFallingPathSum(new int[][]{
                {-19,57}, {-40,-5}
        });
    }

}
