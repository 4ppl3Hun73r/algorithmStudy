package problems;

import java.util.Arrays;

// https://leetcode.com/problems/reshape-the-matrix/
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int orginR = mat.length;
        int orginC = mat[0].length;

        if (orginR * orginC != r * c) {
            return mat;
        }

        int[][] newMat = new int[r][c];
        int tR = 0;
        int tC = 0;
        for (int i = 0; i < orginR; i++) {
            for (int j = 0; j < orginC; j++) {
                newMat[tR][tC++] = mat[i][j];
                if (tC == c) {
                    tR++;
                    tC = 0;
                }
            }
        }

        return newMat;
    }

    public static void main(String[] args) {
        ReshapeTheMatrix r = new ReshapeTheMatrix();
        System.out.println(Arrays.deepToString(r.matrixReshape(new int[][]{
                {1,2},
                {3,4}
        }, 1, 4)));
    }
}
