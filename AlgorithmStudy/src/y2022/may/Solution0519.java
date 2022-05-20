package y2022.may;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public class Solution0519 {
    public int longestIncreasingPath(int[][] matrix) {
        /*
        가장 긴 증가하는 경로 찾기
         */
        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        cache = new int[row][col];

        // O(n*n)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(getLongestPath(i, j, matrix), ans);
            }
        }

        return ans;
    }

    int[][] cache;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int getLongestPath(int row, int col, int[][] matrix) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int path = 1;
        int longPath = 0;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];

            if (r < 0 || c < 0 || r == matrix.length || c == matrix[0].length) {
                continue;
            }
            if (matrix[r][c] > matrix[row][col]) {
                longPath = Math.max(longPath, getLongestPath(r, c, matrix));
                /*
                [[9,9,4],  //2 or 2
                 [6,6,8],
                 [2,1,1]]

                 cache
                [[1,1,2],
                 [2,2,1],
                 [3,4,2]]
                 */
            }
        }

        path = path + longPath;
        cache[row][col] = path;
        return path;
    }
}