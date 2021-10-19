package problems;

import java.util.Arrays;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int targetRow = -1;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][col - 1]) {
                targetRow = i;
                break;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        return Arrays.binarySearch(matrix[targetRow], target) > -1;
    }
}
