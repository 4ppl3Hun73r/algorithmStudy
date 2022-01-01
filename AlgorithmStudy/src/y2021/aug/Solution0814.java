package y2021.aug;

import java.util.Arrays;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/
public class Solution0814 {

    public void setZeroes(int[][] matrix) {

        // You must do it in place.
        // m*n 보다 적은 공간으로 처리 하기
        // A simple improvement uses O(m + n) space, but still not the best solution.
        /*

        /*

        int m = matrix.length;
        int n = matrix[0].length;
        int[] zeroRowCol = new int[m + n];

        for (int i = 0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowCol[i] = 1;
                    zeroRowCol[m + j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (zeroRowCol[i] == 1 || zeroRowCol[m + j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        */

        int m = matrix.length;
        int n = matrix[0].length;
        int check = 0; // row[0] 중 0이 있으면 1, col[0]중 0이 있으면 2, 둘다면 3 // 해당 없으면 0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && i != 0 && j != 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                if (matrix[i][j] == 0 && j == 0) {
                    if (check == 0) check = 1;
                    if (check == 2) check = 3;
                }
                if (matrix[i][j] == 0 && i == 0) {
                    if (check == 0) check = 2;
                    if (check == 1) check = 3;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (check != 0) {
            if (check == 1 || check == 3) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (check == 2 || check == 3) {
                for (int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {

        Solution0814 s = new Solution0814();
        int[][] arr = new int[][]{
            {0,1,2,0},{3,4,5,2},{1,3,1,5}
        };
        arr = new int[][]{
                {1,0,3}
        };
        arr = new int[][]{
                {1}, {0}, {3}
        };
        s.setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));

    }
}
