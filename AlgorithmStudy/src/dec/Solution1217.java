package dec;

// https://leetcode.com/problems/maximal-square/
public class Solution1217 {
    public int maximalSquare(char[][] matrix) {
        /*
            1 0 1 0 0
            1 0 1 1 1
            1 1 1 1 1
            1 0 0 1 0
dp
          0 0 0 0 0 0
          0 1 0 1 0 0
          0 1 0 1 1 1
          0 1 1 1 2 2
          0 1 0 0 1 0
            dp[i][j] = min(dp[i - 1][j], dp[i-1][j-1], dp[i][j-1]) + 1;
         */
        int n = matrix.length;
        int[][] dp = new int[n + 1][matrix[0].length + 1];
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int num = matrix[i - 1][j - 1] - '0';
                if (num == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }

    public static void main(String[] args) throws Exception {
        Solution1217 s = new Solution1217();
        System.out.println(s.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        }));

        System.out.println(s.maximalSquare(new char[][]{
                {'1', '0'},
                {'0', '1'}
        }));

        System.out.println(s.maximalSquare(new char[][]{
                {'0'}
        }));
    }

}
