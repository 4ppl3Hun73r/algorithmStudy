package problems;

import model.GridCodec;

import java.util.Arrays;

// https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][col - 1]) {
                int c = Arrays.binarySearch(matrix[i], target);
                if (c >= 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII searchA2DMatrixII = new SearchA2DMatrixII();
        GridCodec g = new GridCodec();

        searchA2DMatrixII.searchMatrix(g.getIntGrid("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 5);
    }

}
