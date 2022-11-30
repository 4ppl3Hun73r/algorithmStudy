package y2022.nov;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
public class Solution1121 {
    public int nearestExit(char[][] maze, int[] entrance) {
        /*
         [.][+][.]
         [.][+][.]
         [.][.][.]
         */
        Queue<int[]> queue = new LinkedList<>();
        int dirs[][] = new int[][] {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        while(!queue.isEmpty()) {
            int y = queue.peek()[0];
            int x = queue.peek()[1];
            int step = queue.poll()[2];

            for(int d = 0 ; d < 4; d++) {
                int ny = y + dirs[d][0];
                int nx = x + dirs[d][1];

                if (ny < 0 || nx < 0 || ny >= maze.length || nx >= maze[0].length) {
                    if (y == entrance[0] && x == entrance[1]) {
                        continue;
                    }
                    return step;
                }
                if (maze[ny][nx] == '.')  {
                    queue.offer(new int[]{ny, nx, step + 1});
                    maze[ny][nx] = '+';
                }
            }
        }

        return -1;
    }
}
