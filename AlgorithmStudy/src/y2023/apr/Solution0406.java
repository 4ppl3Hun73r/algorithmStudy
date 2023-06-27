package y2023.apr;

import model.GridCodec;

// https://leetcode.com/problems/number-of-closed-islands/
public class Solution0406 {
    boolean[][] visited;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && !visited[i][j] && dfs(grid, i, j)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int[][] grid, int cy, int cx) {
        if (cy == 0 || cx == 0 || cy == grid.length - 1 || cx == grid[0].length - 1) {
            return false;
        }

        visited[cy][cx] = true;
        boolean isIsland = true;
        for (int[] dir : dirs) {
            int ny = cy + dir[0];
            int nx = cx + dir[1];

            if (!visited[ny][nx] && grid[ny][nx] == 0) {
                isIsland &= dfs(grid, ny, nx);
            }
        }

        return isIsland;
    }
    
    public static void main(String[] args) throws Exception {
        Solution0406 s = new Solution0406();
        GridCodec g = new GridCodec();
        
        System.out.println(s.closedIsland(g.getIntGrid("[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]")));
    }

}
