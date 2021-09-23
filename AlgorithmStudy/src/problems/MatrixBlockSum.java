package problems;

// https://leetcode.com/problems/matrix-block-sum/
public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] rangeSum = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                rangeSum[i][j] = rangeSum[i - 1][j] + rangeSum[i][j - 1] - rangeSum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                int r2 = Math.min(i + k + 1, row);
                int c2 = Math.min(j + k + 1, col);

                mat[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        }

        return mat;
    }


    /*
    k = 1
    [[1,2,3],
     [4,5,6],
     [7,8,9]]

// https://leetcode.com/problems/matrix-block-sum/discuss/477036/JavaPython-3-PrefixRange-sum-w-analysis-similar-to-LC-30478
        +-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
        |     | |       |     |        |     |     |     |         |     |     |        |
        |     | |       |     |        |     |     |     |         |     |     |        |
        +-----+-+       |     +--------+     |     |     |         |     +-----+        |
        |     | |       |  =  |              |  +  |     |         |  -  |              | + mat[i][j]
        +-----+-+       |     |              |     +-----+         |     |              |
        |               |     |              |     |               |     |              |
        |               |     |              |     |               |     |              |
        +---------------+     +--------------+     +---------------+     +--------------+

        rangeSum[i+1][j+1] =  rangeSum[i][j+1] + rangeSum[i+1][j]    -   rangeSum[i][j]   + mat[i][j]


        부분 합
        +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
        |               |   |         |    |   |   |           |   |         |    |   |   |          |
        |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
        |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
        |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
        |   |      |    |   |         |    |   |   |           |   |              |   |              |
        |   +------+    |   +---------+    |   +---+           |   |              |   |              |
        |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
        +---------------+   +--------------+   +---------------+   +--------------+   +--------------+

     */
}
