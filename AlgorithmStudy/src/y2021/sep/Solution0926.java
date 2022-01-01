package y2021.sep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3987/
public class Solution0926 {

    private class XYR {
        int x;
        int y;
        int r;
        int s;
        public XYR(int x, int y, int r, int s) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.s = s;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int maxX = grid.length;
        int maxY = grid[0].length;

        if (maxX == 1 && maxY == 1) return 0;

        int desX = maxX - 1;
        int desY = maxY - 1;
        // bfs
        // (x, y, r) r-> remain number obstacles you can remove
        Queue<XYR> queue = new LinkedList<>();
        queue.add(new XYR(0, 0, k, 0));
        boolean[][][] visited = new boolean[maxX][maxY][k + 1];
        visited[0][0][k] = true;
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        while (!queue.isEmpty()) {
            XYR curr = queue.poll();
            for (int[] dir : dirs) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];

                if (newX < 0 || newY < 0 || newX == maxX || newY == maxY) continue;

                if (grid[newX][newY] == 1) {
                    // 장애물이 있으면 장애물 제거
                    // 동일한 r 값을 가지고 방문한적이 없어야함.
                    if (curr.r > 0 && !visited[newX][newY][curr.r - 1]) {
                        queue.add(new XYR(newX, newY, curr.r - 1, curr.s + 1));
                        visited[newX][newY][curr.r - 1] = true;
                    }
                } else {
                    if (newX == desX && newY == desY) {
                        return curr.s + 1;
                    } else if (!visited[newX][newY][curr.r]) {
                        queue.add(new XYR(newX, newY, curr.r, curr.s + 1));
                        visited[newX][newY][curr.r] = true;
                    }
                }
            }
        }

        return -1;
    }

    public int shortestPath2(int[][] grid, int k) {
        int maxX = grid.length;
        int maxY = grid[0].length;

        if (maxX == 1 && maxY == 1) return 0;

        int desX = maxX - 1;
        int desY = maxY - 1;
        // bfs
        // (x, y, r) r-> remain number obstacles you can remove
        Set<String> visited = new HashSet<>();
        Queue<XYR> queue = new LinkedList<>();
        queue.add(new XYR(0, 0, k, 0));
        visited.add("0,0," + k);
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        while (!queue.isEmpty()) {
            XYR curr = queue.poll();
            for (int[] dir : dirs) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];

                if (newX < 0 || newY < 0 || newX == maxX || newY == maxY) continue;

                if (grid[newX][newY] == 1) {
                    // 장애물이 있으면 장애물 제거
                    // 동일한 r 값을 가지고 방문한적이 없어야함.
                    String key = String.format("%d,%d,%d", newX, newY, (curr.r - 1));
                    if (curr.r > 0 && !visited.contains(key)) {
                        queue.add(new XYR(newX, newY, curr.r - 1, curr.s + 1));
                        visited.add(key);
                    }
                } else {
                    String key = String.format("%d,%d,%d", newX, newY, curr.r);
                    if (newX == desX && newY == desY) {
                        return curr.s + 1;
                    } else if (!visited.contains(key)) {
                        queue.add(new XYR(newX, newY, curr.r, curr.s + 1));
                        visited.add(key);
                    }
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution0926 s = new Solution0926();

        System.out.println(s.shortestPath(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        }, 1));

        System.out.println(s.shortestPath(new int[][]{
                {0,1,0,0},
                {1,0,1,1},
                {1,0,0,1},
                {0,0,1,0}
        }, 13));

        System.out.println(s.shortestPath(new int[][]{
                {0,1,0,0,0,1,0,0},
                {0,1,0,1,0,1,0,1},
                {0,0,0,1,0,0,1,0}
        }, 1));

    }

}

/*
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]]
 k = 1
 (0,0) -> (5, 2) 10걸음 가야하는데, k 개 만큼 1을 지울수 있음
 (1,0)이나 (4, 2)를 지우면 6개만에 갈수 있음
 도착 못하면 -1 반환
 */