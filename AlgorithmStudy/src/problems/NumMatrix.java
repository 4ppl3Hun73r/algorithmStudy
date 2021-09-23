package problems;

// https://leetcode.com/problems/range-sum-query-2d-immutable/
// problems.MatrixBlockSum
public class NumMatrix {
    int row;
    int col;
    int[][] rangeSum;

    public NumMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        rangeSum = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                rangeSum[i][j] = rangeSum[i - 1][j] + rangeSum[i][j - 1] - rangeSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row2++;
        col2++;

        return rangeSum[row2][col2] - rangeSum[row2][col1] - rangeSum[row1][col2] + rangeSum[row1][col1];
    }
}
