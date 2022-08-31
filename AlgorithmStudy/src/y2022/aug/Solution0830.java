package y2022.aug;

import model.GridCodec;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/
public class Solution0830 {
    public void rotate(int[][] matrix) {
        /*
        90도 회전 -> 새로운 matrix 만들면 안되요.

        [[1,2,3],
         [4,5,6],
         [7,8,9]]

         [[7,4,1],
          [8,5,2],
          [9,6,3]]

            (1,2,3,4)

          (0, 0) -> (0, 2)
          (0, 2) -> (2, 2)
          (2, 2) -> (2, 0)
          (2, 0) -> (0, 0)

          (y,x) -> (x,y) -> (x, n-y-1)

          (0, 1) -> (1, 2) -> (1,0) -> (1, 2)
          (1, 2) -> (2, 1)
          (2, 1) -> (1, 0)
          (1, 0) -> (0, 1)
         */

        System.out.println(Arrays.deepToString(matrix).replaceAll("],", "\n"));

        int n = matrix.length;
        for(int y = 0 ; y < n ; y++) {
            for(int x = 0 ; x <= y ; x++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix).replaceAll("],", "\n"));

        for(int y = 0 ; y < n ; y++) {
            for(int x = 0 ; x < n / 2 ; x++) {
                int temp = matrix[y][x];
                matrix[y][x] = matrix[y][n-x-1];
                matrix[y][n-x-1] = temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix).replaceAll("],", "\n"));

        /*int y = 0;
        int x = 1;
        int temp = matrix[y][x];
        for (int i = 0; i < 4; i++) {
            int nextY = x;
            int nextX = n - y - 1;
            System.out.println(nextY + "," + nextX);
            int temp2 = matrix[nextY][nextX];
            matrix[nextY][nextX] = temp;
            temp = temp2;
            y = nextY;
            x = nextX;
        }*/

    }

    public static void main(String[] args) throws Exception {
        Solution0830 s = new Solution0830();
        GridCodec g = new GridCodec();

        s.rotate(g.getIntGrid("[[1,2,3],[4,5,6],[7,8,9]]"));

        //s.rotate(g.getIntGrid("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]"));
    }
}
