package y2022.oct;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/toeplitz-matrix/
public class Solution1031 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Toeplitz(테플리츠) 행결 인가?
        // 왼쪽 상단과 오른쪽 하단이 동일함
        // m[i-1][j-1] == m[i][j] == m[i+1][j+1]

        /*
         [1][2][3][4][5][6]
         [7][1][2][3][4][2]
         [ ][ ][X][ ][ ][ ]
         [ ][ ][ ][X][ ][ ]
         [ ][ ][ ][ ][X][ ]
         [ ][ ][ ][ ][ ][X]

         row + one col + temp val 1
         1 2 3 4 5 6 7 1
         queue row + 1 size queue
         queue is full -> poll == offer => 계속, != => return false;
         */

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!isToeplitz(matrix, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isToeplitz(int[][] matrix, int r, int c) {
        int r2 = r + 1;
        int c2 = c + 1;

        if (r2 >= matrix.length || c2 >= matrix[0].length) {
            return true;
        }

        return matrix[r][c] == matrix[r2][c2];
    }

           /*
         [1][2][3][4][5][6]
         [7][1][2][3][4][2]
         [2][1 ][0][-1][ ][ ]
         [3][2 ][1][X][ ][ ]
         [ ][ ][ ][ ][X][ ]
         [ ][ ][ ][ ][ ][X]

         R(matrix) + R(map)
         R(matrix) + R(queue) + 2(temp value)
            */
    public boolean isToeplitzMatrixMap(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }

}
