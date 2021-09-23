package problems;

// https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i  < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        // 2000000000
        // 1596692176
        System.out.println(u.uniquePaths(20, 20));
    }
}


/*
3, 7

 [R, 1, 1, 1, 1, 1, 1]
 [1, 2, 3, 4, 5, 6, 7]
 [1, 3, 6, 10, 15, 21, 28]


7C3 -> 35 => 35 - 7
3C2 -> 6 => 6 - 3
3C3 -> ???

 */