package problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-bridge/
public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        /*
        0: water
        1: land

        0을 1로 바꿔서 두개의 섬을 연결하기
        가장 작은 바꾸는 0의 수를 구하라

        1 1 1 1 1
        0 0 1 0 1
        1 0 0 0 1
        */

        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];
        int ans = Integer.MAX_VALUE;

        int num = 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    changeLandNumber(grid, i, j, num++);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = Integer.MAX_VALUE;
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0}); // x, y, zeroCnt;
                    visited[i][j] = 0;
                }
            }
        }

        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int[] dir : dirs) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];

                if (x < 0 || y < 0 || x == row || y == col) {
                    continue;
                }
                // 가려고 하는 노드에 이미 방문 흔적이 있는지 확인
                // 방문했는데 현재 내 Step보다 작으면 넘어가고 크면 업데이트 후 내가 감
                int visitedStep = visited[x][y];
                int nextStep = node[2] + (grid[x][y] == 0 ? 1 : 0);
                if (nextStep < visitedStep) {
                    if (grid[x][y] == 3) {
                        ans = Math.min(ans, nextStep);
                    } else {
                        queue.add(new int[]{x, y, nextStep});
                        visited[x][y] = nextStep;
                    }
                }
            }
        }

        return ans;
    }

    private void changeLandNumber(int[][] grid, int i, int j, int num) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
            return ;
        }

        grid[i][j] = num;

        changeLandNumber(grid, i - 1, j, num);
        changeLandNumber(grid, i + 1, j, num);
        changeLandNumber(grid, i, j - 1, num);
        changeLandNumber(grid, i, j + 1, num);
    }

}
