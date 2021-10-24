package problems;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int result = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    switchLands(grid, i, j);
                }
            }
        }

        return result;
    }

    private void switchLands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length) {
            return ;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '0';

            switchLands(grid, i - 1, j);
            switchLands(grid, i + 1, j);
            switchLands(grid, i, j - 1);
            switchLands(grid, i, j + 1);
        }
    }
}
