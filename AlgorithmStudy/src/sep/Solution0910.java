package sep;

import java.util.*;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3969/
public class Solution0910 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        // sb
        // [5, 5, 5, 5, 5, 5]
        // [5, 5, 5, 5, 5, 5]
        // [5, 5, 5, 5, 5, 5]
        // [5, 5, 5, 5, 5, 5]
        // [5, 5, 5, 5, 5, 5]
        // [5, 5, 5, 5, 5, 5]

        // ym
        // arr : left -> right / right -> left / top->down / down->top
        // [1, 2, 3, 4, 5]
        // [1, 2, 3, 4, 5]
        // [1, 2, 3, 4, 5]
        // [1, 2, 3, 4, 5]
        // [1, 2, 0, 1, 2]

        // [5, 4, 3, 2, 1]
        // [5, 4, 3, 2, 1]
        // [5, 4, 3, 2, 1]
        // [5, 4, 3, 2, 1]
        // [2, 1, 0, 2, 1]

        // [1, 1, 1, 1, 1]
        // [2, 2, 2, 2, 2]
        // [3, 3, 3, 3, 3]
        // [4, 4, 4, 4, 4]
        // [5, 5, 0, 5, 5]

        // [5, 5, 4, 5, 5]
        // [4, 4, 3, 4, 4]
        // [3, 3, 2, 3, 3]
        // [2, 2, 1, 2, 2]
        // [1, 1, 0, 1, 1]

        // [1, 1, 1, 1, 1]
        // [1, 2, 2, 2, 1]
        // [1, 2, 2, 2, 1]
        // [1, 2, 1, 2, 1]
        // [1, 1, 0, 1, 1]

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = n;
            }
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        // left -> right
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            int top = 0;
            int down = 0;
            for (int j = 0, k = n - 1; j < n && k >= 0; j++, k--) {
                // left -> right
                grid[i][j] = Math.min(grid[i][j], left = grid[i][j] == 0 ? 0 : left + 1);
                // top -> down
                grid[j][i] = Math.min(grid[j][i], top = grid[j][i] == 0 ? 0 : top + 1);

                // right -> left
                grid[i][k] = Math.min(grid[i][k], right = grid[i][k] == 0 ? 0 : right + 1);
                // down -> top
                grid[k][i] = Math.min(grid[k][i], down = grid[k][i] == 0 ? 0 : down + 1);
            }
        }
        /*// right -> left
        for (int i = 0; i < n; i++) {
            int right = 1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    right = 0;
                }
                grid[i][j] = Math.min(grid[i][j], right);
                right ++;
            }
        }
        // top -> down
        for (int j = 0; j < n; j++) {
            int top = 1;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0) {
                    top = 0;
                }
                grid[i][j] = Math.min(grid[i][j], top);
                top ++;
            }
        }
        // down -> top
        for (int j = n - 1; j >= 0; j--) {
            int down = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 0) {
                    down = 0;
                }
                grid[i][j] = Math.min(grid[i][j], down);
                down ++;
            }
        }*/

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }

    // timeout exceeded
    public int orderOfLargestPlusSign2(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);

        int ans = 0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                int k = 0;
                while (k <= r && r < N-k && k <= c && c < N-k &&
                        !banned.contains((r-k)*N + c) &&
                        !banned.contains((r+k)*N + c) &&
                        !banned.contains(r*N + c-k) &&
                        !banned.contains(r*N + c+k))
                    k++;

                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution0910 s = new Solution0910();

        //System.out.println(s.orderOfLargestPlusSign(5, new int[][] {{4, 2}}));
        //System.out.println(s.orderOfLargestPlusSign(1, new int[][] {{0, 0}}));

        long time = System.currentTimeMillis();
        System.out.println(s.orderOfLargestPlusSign(500, new int[][] {{499, 499}, {234, 231}}));
        System.out.println(System.currentTimeMillis() - time); // 13ms
        time = System.currentTimeMillis();
        System.out.println(s.orderOfLargestPlusSign2(500, new int[][] {{499, 499}, {234, 231}}));
        System.out.println(System.currentTimeMillis() - time); // 667ms
    }
}
