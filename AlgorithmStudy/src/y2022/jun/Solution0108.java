package y2022.jun;

import java.util.Arrays;

public class Solution0108 {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c]; // [row][c1][c2] == row에서 robot1이 c1에 있고, robot2 가 c2에 있을때 최대 값

        for (int row = r - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < c; col1++) {
                for (int col2 = 0; col2 < c; col2++) {
                    int result = 0;

                    result += grid[row][col1];
                    if (col1 != col2) {
                        result += grid[row][col2];
                    }
                    if (row != r - 1) {
                        int max = 0;
                        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                                if (newCol1 >= 0 && newCol1 < c && newCol2 >= 0 && newCol2 < c) {
                                    max = Math.max(max, dp[row + 1][newCol1][newCol2]);
                                }
                            }
                        }
                        result += max;
                    }
                    dp[row][col1][col2] = result;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        return dp[0][0][c - 1];
    }

    public static void main(String[] args) {
        Solution0108 s = new Solution0108();

        System.out.println(s.cherryPickup(new int[][]{
                {3,1,1},{2,5,1},
                {1,5,5},{2,1,1}
        }));
    }
}
