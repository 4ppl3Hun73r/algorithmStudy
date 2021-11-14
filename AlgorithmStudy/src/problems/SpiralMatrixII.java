package problems;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int col = 0;
        int row = 0;
        int boundColMin = 0;
        int boundColMax = n - 1;
        int boundRowMin = 1;
        int boundRowMax = n - 1;
        int direction = 0; // 0 is right, 1 is down, 2 is left, 3 is up
        for (int i = 0; i < n * n; i++) {
            matrix[row][col] = num;
            num++;
            if (direction == 0) {
                col++;
                if (col == boundColMax) {
                    direction = 1;
                    boundColMax--;
                }
            } else if (direction == 1) {
                row++;
                if (row == boundRowMax) {
                    direction = 2;
                    boundRowMax--;
                }
            } else if (direction == 2) {
                col--;
                if (col == boundColMin) {
                    direction = 3;
                    boundColMin ++;
                }
            } else if (direction == 3) {
                row--;
                if (row == boundRowMin) {
                    direction = 0;
                    boundRowMin++;
                }
            }
        }

        return matrix;
    }
}
