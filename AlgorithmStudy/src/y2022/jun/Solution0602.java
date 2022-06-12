package y2022.jun;

// https://leetcode.com/problems/transpose-matrix/
public class Solution0602 {
    public int[][] transpose(int[][] matrix) {
        /*
        Input: matrix = [[1,2,3],[4,5,6]]
        Output: [[1,4],[2,5],[3,6]]
         */

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] grid = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[j][i] = matrix[i][j];
            }
        }

        return grid;
    }
}
