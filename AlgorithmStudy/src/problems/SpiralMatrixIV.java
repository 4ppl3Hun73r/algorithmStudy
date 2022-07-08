package problems;

import model.ListNode;

import java.util.Arrays;

public class SpiralMatrixIV {

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], -1);
        }
        int x = 0;
        int y = 0;
        int direction = 0; // 0 -> left, 1 -> down, 2 -> right, 3 -> up
        while (head != null) {
            grid[y][x] = head.val;
            head = head.next;

            if (direction == 0) {
                x++;
            } else if (direction == 1) {
                y++;
            } else if (direction == 2) {
                x--;
            } else if (direction == 3) {
                y--;
            }

            if (x == n || y == m || x < 0 || y < 0 || grid[y][x] != -1) {
                if (direction == 0) {
                    x--;
                    y++;
                } else if (direction == 1) {
                    y--;
                    x--;
                } else if (direction == 2) {
                    x++;
                    y--;
                } else if (direction == 3) {
                    y++;
                    x++;
                }
                direction = (direction + 1) % 4;
            }
        }

        return grid;
    }


}
