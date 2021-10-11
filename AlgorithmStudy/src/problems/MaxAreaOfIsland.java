package problems;

import model.GridCodec;

import java.util.Arrays;

// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland {
    int row;
    int col;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }

        System.out.println(Arrays.deepToString(grid));

        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == row || c == col || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;
        return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        GridCodec g = new GridCodec();

        System.out.println(m.maxAreaOfIsland(
                g.getIntGrid("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]")
        ));
    }
}
