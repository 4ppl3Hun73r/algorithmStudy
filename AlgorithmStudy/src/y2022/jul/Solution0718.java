package y2022.jul;

import model.GridCodec;

// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
public class Solution0718 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        /*
        [0][1][0]
        [1][0][1]
        [0][1][0]
        target = 1
        4개

        prefixsum -> (x0, y0) ~ (x1, y1) 방법
        [a][b][c]
        [d][e][f]
        [g][h][i]

        [a][a+b][a+b+c]
        [a+d][a+b+d+e][a+b+c+d+e+f]
        [a+d+g][a+b+d+e+g+h][a+b+c+d+e+f+g+h+i]

        e + f + h + i = [a+b+c+d+e+f+g+h+i]
                       -(a    +d    +g)
                       -(a+b+c)
                       +(a)
                                 e+f  +h+i
        (x1, y1) - (x0 - 1, y1) - (x1, y0 - 1) + (x0 -1, y0 - 1) = (x0, y0) ~ (x1, y1)
         */
        int ans = 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] prefixSum = new int[row][col];
        for (int i = 0; i < row; i++) {
            prefixSum[i][0] = matrix[i][0];
            for (int j = 1; j < col; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i][j - 1];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }

        // System.out.println(Arrays.deepToString(prefixSum).replaceAll("],", "\n"));
        // System.out.println(rangeSum(prefixSum, 1,1, 2, 2));
        // System.out.println(rangeSum(prefixSum, 0, 0, 1, 1));
        // System.out.println(rangeSum(prefixSum, 0, 1, 0, 2));

        // 전부다 탐색??

        // (0, 0) -> (0, 1) .....
        // (0, 2) -> (0, 2) ....

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for(int rowLen = 0; rowLen < row; rowLen++) {
                    for (int colLen = 0; colLen < col; colLen++) {
                        if ( j + colLen >= col || i + rowLen >= row) {
                            break;
                        }
                        if (rangeSum(prefixSum, j, i, j + colLen, i + rowLen) == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    private int rangeSum(int[][] prefixSum, int x0, int y0, int x1, int y1) {
        //(x1, y1) - (x0 - 1, y1) - (x1, y0 - 1) + (x0 -1, y0 - 1) = (x0, y0) ~ (x1, y1)
        return prefixSum[y1][x1] - (x0 - 1 >= 0 ? prefixSum[y1][x0 - 1] : 0)
                - (y0 - 1 >= 0 ? prefixSum[y0 - 1][x1] : 0)
                + (x0 - 1 >= 0 && y0 - 1 >= 0 ? prefixSum[y0 - 1][x0 - 1] : 0);


    }

    public static void main(String[] args) throws Exception {
        Solution0718 s = new Solution0718();

        GridCodec g = new GridCodec();

        System.out.println(s.numSubmatrixSumTarget(g.getIntGrid("[[0,1,0],[1,1,1],[0,1,0]]"), 0));
    }


    public int numSubmatrixSumTarget11(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;

        // traverse upper boundary
        for (int top = 0; top < m; top++) {

            // for each upper boundary, we have a prefix sum array
            int[] sum = new int[n];

            // traverse lower boundary
            for (int bottom = top; bottom < m; bottom++) {

                // count the prefix sum for each column
                for (int col = 0; col < n; col++) {
                    // [0,1,0] => prefixsum [0, 1, 1]
                    sum[col] += matrix[bottom][col];
                }

                /*
                [0,1,0]
                [0,1,0]
                [0,1,0]
                 */

                // traverse left and right boundary
                for (int left = 0; left < n; left++) {
                    int cnt = 0;
                    for (int right = left; right < n; right++) {
                        cnt += sum[right];
                        if (cnt == target) res++;
                    }
                }
            }
        }
        return res;
    }

}
