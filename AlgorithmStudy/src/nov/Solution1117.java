package nov;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/
public class Solution1117 {
    public int uniquePaths(int m, int n) {
        // (0, 0) 에서 -> (m,n) 까지의 모든 경로 의 수
        // m = row, n = col
        // 아래 / 오른쪽으로만 움직일 수 있음
        // DP, combination
        /*
        [S][→][→][→][→][↓]
        [↓][ ][ ][ ][ ][↓]
        [→][→][→][→][→][E]

        [S][1][1][1][1][1][1]
        [1][2][3][4][5][6][7]
        [1][3][6][10][15][21][[E] => 28 ?

        It's guaranteed that the answer will be less than or equal to 2 * 10^9
         */

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) throws Exception {
        Solution1117 s = new Solution1117();

        System.out.println(s.uniquePaths(11, 11));

    }
}
