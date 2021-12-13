package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/as-far-from-land-as-possible/
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    grid[i][j] = -1;
                }
            }
        }

        if (queue.isEmpty() || queue.size() == r * c) {
            return -1;
        }

        int[][] dirs = new int[][]{
                //{-1, -1, 2},
                {-1, 0, 1},
                //{-1, 1, 2},
                {0, -1, 1},
                {0, 1, 1},
                //{1, -1, 2},
                {1, 0, 1}
                //{1, 1, 2}
        };
        int max = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            int currentVal = grid[pos[0]][pos[1]];
            for(int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if (x < 0 || y < 0 || x == r || y == c || grid[x][y] == -1) {
                    continue;
                }

                int nextVal = grid[x][y];
                if (currentVal < nextVal || nextVal == 0) {
                    int newVal = Math.max(nextVal, pos[2] + dir[2]);
                    if (newVal != nextVal) {
                        grid[x][y] = newVal;
                        queue.add(new int[]{x, y, grid[x][y]});
                        max = Math.max(newVal, max);
                    }

                }
            }
        }
        System.out.println(Arrays.deepToString(grid));

        return max;
    }

    public static void main(String[] args) throws Exception {
        AsFarFromLandAsPossible a = new AsFarFromLandAsPossible();

        System.out.println(a.maxDistance(new int[][]{
                {1,0,1},
                {0,0,0},
                {1,0,1}
        }));

        System.out.println(a.maxDistance(new int[][]{
                {1,0,0},
                {0,0,0},
                {0,0,0}
        }));
    }
}
