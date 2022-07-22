package y2022.jul;

// https://leetcode.com/problems/max-area-of-island/
public class Solution0715 {
    public int maxAreaOfIsland(int[][] grid) {
        /*
        dfs or bfs

        grid[x][y] = 0 => 바다
        grid[x][y] = 1 => 섬
        1이 4 방향으로 연결되어 있으면 하나의 섬

         */

        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || grid.length == x || grid[0].length == y || grid[x][y] != 1) {
            return 0;
        }

        grid[x][y] = 0;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
