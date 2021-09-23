package problems;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) return 0;

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] != 1) {
                obstacleGrid[i][0] = -1;
            } else {
                break;
            }
        }

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] != 1) {
                obstacleGrid[0][i] = -1;
            } else {
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) continue;

                obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j])
                        + (obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1]);
            }
        }

        return -obstacleGrid[row - 1][col - 1];
    }
}
/*
[[0,0,0],
 [0,1,0],
 [0,0,0]]

 [1,1,1],
 [1,a,1],
 [1,1,2]]

 */
