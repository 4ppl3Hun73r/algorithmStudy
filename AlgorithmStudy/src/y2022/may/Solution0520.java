package y2022.may;

// https://leetcode.com/problems/unique-paths-ii/
public class Solution0520 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        (0, 0) -> (row - 1, col - 1) 까지 이동하는 모든 경우의 수를 구하시오.
        grid[i][j] == 1 은 장애물로 이동 불가능
        로봇은 아래 / 오른쪽으로만 이동 가능

        [[0,0,0]
        ,[01,0]
        ,[0,0,0]]

        [[1,1,1]
        ,[1,2,3]
        ,[1,3,6]]  4개?

        [[1,1,1]
        ,[1,-,1]
        ,[1,1,2]] -> 2
         */
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        for(int y = 0 ; y < row; y++) {
            if(obstacleGrid[y][0] != 1)
                obstacleGrid[y][0] = -1;
            else
                break;
        }

        for (int x = 0; x < col; x++) {
            if (obstacleGrid[0][x] != 1) {
                obstacleGrid[0][x] = -1;
            } else {
                break;
            }
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] += (obstacleGrid[i - 1][j] != 1) ? obstacleGrid[i - 1][j] : 0;
                    obstacleGrid[i][j] += (obstacleGrid[i][j - 1] != 1 ? obstacleGrid[i][j - 1] : 0);
                }
            }
        }

        /*



        [[0,0]
        ,[1,1]
        ,[0,0]]

        [[-1,-1]
        ,[1,1]
        ,[0,0]]
         */

        return -obstacleGrid[row - 1][col - 1];
    }
}
