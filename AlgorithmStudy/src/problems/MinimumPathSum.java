package problems;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i  < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;;
                int upR = i - 1;
                int leftC = j - 1;
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if (upR >= 0) {
                    up = grid[upR][j];
                }
                if (leftC >= 0) {
                    left = grid[i][leftC];
                }

                grid[i][j] += Math.min(up, left);
                //System.out.println(Arrays.deepToString(grid));
            }
        }

        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        System.out.println(m.minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
