package problems;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] dp = new int[col + 1]; // row를 게속 누적해서 구함.
        // dp[i] = min(dp[i], dp[i - 1], prev)  + 1;
        int maxLen = 0;
        int prev = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=col; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    // dp [j - 1] -> 전줄 전칸
                    // dp [j] -> 전줄 이번 칸
                    // prev -> 저번에 dp[j - 1]
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }


        return maxLen * maxLen;
    }



    public static void main(String[] args) {
        MaximalSquare m = new MaximalSquare();
        System.out.println(m.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
