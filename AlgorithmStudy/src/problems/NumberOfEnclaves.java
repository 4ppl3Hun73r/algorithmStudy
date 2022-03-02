package problems;

// https://leetcode.com/problems/number-of-enclaves/
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        /*
        0 : see
        1 : land
         */

        // 외각을 돌면서 1과 연결된 cell 을 0으로 변경해줌
        // 다 돈 후 count 1

        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < c; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            if (grid[r - 1][i] == 1) {
                dfs(grid, r - 1, i);
            }
        }

        for (int i = 0; i < r; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][c - 1] == 1) {
                dfs(grid, i, c - 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    ans ++;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[r].length || grid[r][c] == 0) {
            return ;
        }

        grid[r][c] = 0;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
