package y2022.jul;

import java.util.Arrays;

// https://leetcode.com/problems/out-of-boundary-paths/
public class Solution0716 {
    int mod = (int) (1e9) + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        /*
        [0][1]
        [1][ ]
         */

        int[][][] cache = new int[m][n][maxMove + 1];
        for (int[][] init : cache) {
            for (int[] init2 : init) {
                Arrays.fill(init2, -1);
            }
        }

        return findPaths(m, n, maxMove, startRow, startColumn, cache);
    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] cache) {


        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }

        if (cache[startRow][startColumn][maxMove] >= 0) {
            return cache[startRow][startColumn][maxMove];
        }

        cache[startRow][startColumn][maxMove] = (
                (findPaths(m, n, maxMove - 1, startRow - 1, startColumn, cache)
                + findPaths(m, n, maxMove - 1, startRow + 1, startColumn, cache)
                ) % mod
                + (findPaths(m, n, maxMove - 1, startRow, startColumn - 1, cache)
                + findPaths(m, n, maxMove - 1, startRow, startColumn + 1, cache)) % mod
        ) % mod;

        return cache[startRow][startColumn][maxMove];
    }


    public static void main(String[] args) {


        Solution0716 s = new Solution0716();

        System.out.println(s.findPaths(50, 50, 50, 4, 7));
    }
}
