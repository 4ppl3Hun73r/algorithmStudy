package problems;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int len = mat.length;

        int left = 0;
        int right = len - 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (mat[i][left] + mat[i][right]);
            if (left == right) {
                sum -= mat[i][left];
            }
            left++;
            right--;
        }


        return sum;
    }
}
