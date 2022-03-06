package problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        /*
        . => empty
        + => wall
         */

        int row = maze.length;
        int col = maze[0].length;
        int[][] visited = new int[row][col];
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = Integer.MIN_VALUE;

        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == 0 || node[0] == row - 1 || node[1] == 0 || node[1] == col - 1) {
                if (node[0] != entrance[0] || node[1] != entrance[1]) {
                    ans = Math.min(ans, node[2]);
                    continue;
                }
            }

            for (int[] dir : dirs) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];

                if (x < 0 || y < 0 || x == row || y == col || maze[x][y] == '+') {
                    continue;
                }

                int visitedStep = visited[x][y];
                if (visitedStep == 0) {
                    queue.add(new int[]{x, y, node[2] + 1});
                    visited[x][y] = node[2] + 1;
                } else {
                    int nextStep = node[2] + 1;
                    if (nextStep < visitedStep) {
                        queue.add(new int[]{x, y, nextStep});
                        visited[x][y] = nextStep;
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze n = new NearestExitFromEntranceInMaze();

        System.out.println(n.nearestExit(new char[][]{
                {'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}
        }, new int[]{1,2})); // ["+","+",".","+"],[".",".",".","+"],["+","+","+","."]
    }
}
