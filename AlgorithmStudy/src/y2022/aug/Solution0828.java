package y2022.aug;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-the-matrix-diagonally/
public class Solution0828 {
    public int[][] diagonalSort(int[][] mat) {
        /*
        대각선으로 정렬

        [[11,25,66,1,69,7],
         [23,55,17,45,15,52],
         [75,31,36,44,58,8],
         [22,27,33,25,68,4],
         [84,28,14,11,5,50]]


        [[5, 17, 4, 1,52,7],
         [11,11,25,45,8,69],
         [14,23,25,44,58,15],
         [22,27,31,36,50,66],
         [84,28,75,33,55,68]]

         (i, j) -> i - j
         */

        Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap<>();

        int row = mat.length;
        int col = mat[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int diagonalNum = i - j;
                if (!diagonalMap.containsKey(diagonalNum)) {
                    diagonalMap.put(diagonalNum, new PriorityQueue<>());
                }
                diagonalMap.get(diagonalNum).offer(mat[i][j]);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int diagonalNum = i - j;
                mat[i][j] = diagonalMap.get(diagonalNum).poll();
            }
        }

        return mat;
    }
}
