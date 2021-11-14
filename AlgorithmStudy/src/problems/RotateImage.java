package problems;

public class RotateImage {
    public void rotate(int[][] matrix) {

        int len = matrix.length;

        for (int i = 0; i < (len / 2); i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    int i2 = j;
                    int j2 = len - 1 - i;
                    int t2 = matrix[i2][j2];
                    matrix[i2][j2] = temp;
                    temp = t2;
                    i = i2;
                    j = j2;
                }
            }
        }
    }
}
