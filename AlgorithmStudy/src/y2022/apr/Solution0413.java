package y2022.apr;

import java.util.Arrays;

// https://leetcode.com/problems/spiral-matrix-ii/
public class Solution0413 {

    public int[][] generateMatrix(int n) {
        /*
          n 이 들어오면
          n * n 으로 grid 를 만듬
          (0,0) -> (0, 1) 순서로 값을 채워 나감. 끝에 도달하면 방향 전환
         */
        int[][] grid = new int[n][n];

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; // (row, col)
        int direction = 0; // 0 -> east, 1 -> south, 2 -> west, 3 -> north
        int row = 0, col = 0;

        for (int i = 1; i <= n * n; i++) {
            grid[row][col] = i;

            row = row + dirs[direction][0];
            col = col + dirs[direction][1];

            if (row >=n || col >=n || row < 0 || col < 0 || grid[row][col] != 0) {
                // rollback
                row = row - dirs[direction][0];
                col = col - dirs[direction][1];
                direction = (direction + 1) % 4; // good b
                // 맞는 방향으로 전진
                row = row + dirs[direction][0];
                col = col + dirs[direction][1];
            }


        }

        System.out.println(Arrays.deepToString(grid).replaceAll("],","\n"));

        return grid;
    }

    public static void main(String[] args) throws Exception {
        Solution0413 s = new Solution0413();

        System.out.println(s.generateMatrix(1));
        System.out.println(s.generateMatrix(3));
        System.out.println(s.generateMatrix(6));
    }

}
