package y2023.apr;

// https://leetcode.com/problems/number-of-enclaves/
public class Solution0407 {

    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                init(grid, i, 0);
            }
            if (grid[i][col - 1] == 1) {
                init(grid, i, col - 1);
            }
        }

        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) {
                init(grid, 0, j);
            }
            if (grid[row - 1][j] == 1) {
                init(grid, row - 1, j);
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void init(int[][] grid, int cy, int cx) {

        grid[cy][cx] = 0;
        for (int[] dir : dirs) {
            int ny = cy + dir[0];
            int nx = cx + dir[1];

            if (ny < 0 || nx < 0 || ny == grid.length || nx == grid[0].length) {
                continue;
            }

            if (grid[ny][nx] == 1) {
                init(grid, ny, nx);
            }
        }
    }
}
