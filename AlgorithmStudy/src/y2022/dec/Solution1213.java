package y2022.dec;

import model.GridCodec;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class Solution1213 {
    public int minFallingPathSum(int[][] matrix) {
        /*
        첫번째 줄에서 시작해서 마지막 줄까지 이동하면서 가장 작은 합을 구하시오
        시작은 어디에서든 가능하다.
        다음 줄로 넘어갈때 왼쪽, 아래, 오른쪽 3가지만 가능하다.
         */

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int row = 1; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                int leftUp = col != 0 ? matrix[row - 1][col - 1] : 0;
                int centerUp = matrix[row - 1][col];
                int rightUp = col != colLen - 1 ? matrix[row - 1][col + 1] : 0;

                if (col == 0) {
                    matrix[row][col] =
                            Math.min(
                                    matrix[row][col] + centerUp, matrix[row][col] + rightUp
                            );
                } else if (col == colLen - 1) {
                    matrix[row][col] =
                            Math.min(
                                    matrix[row][col] + leftUp, matrix[row][col] + centerUp
                            );

                } else {
                    matrix[row][col] = Math.min(
                            matrix[row][col] + leftUp,
                            Math.min(
                                    matrix[row][col] + centerUp, matrix[row][col] + rightUp
                            )
                    );
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int col = 0; col < colLen; col++) {
            min = Math.min(min, matrix[rowLen - 1][col]);
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        Solution1213 s = new Solution1213();
        GridCodec g = new GridCodec();

        System.out.println(s.minFallingPathSum(g.getIntGrid("[[2,1,3],[6,5,4],[7,8,9]]")));
    }
}
