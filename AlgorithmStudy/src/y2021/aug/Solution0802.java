package y2021.aug;

import java.util.*;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/
public class Solution0802 {

    Map<Integer, Integer> map = new HashMap<>();
    int[][] 상하좌우 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Integer[][] newMap;
    Integer 영역번호 = 0;

    public int largestIsland(int[][] grid) {
        int area = 0;
        int n = grid.length;
        newMap = new Integer[n][n];

        Set<Integer> udlr = new HashSet<>(4);
        boolean check = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                check = false;

                udlr.clear();

                for (int[] 위치 : 상하좌우) {
                    int newX = i + 위치[0];
                    int newY = j + 위치[1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                        continue;
                    }

                    if (grid[newX][newY] == 1) {
                        if (newMap[newX][newY] == null) {
                            getIslandSize(newX, newY, grid);
                        }
                        udlr.add(newMap[newX][newY]);
                    }
                }
                int sum = 1;
                for (int t : udlr) {
                    sum += map.get(t);
                }
                area = Math.max(area, sum);
            }
        }

        if (map.isEmpty() && check ) {
            return n * n;
        }


        return area;
    }

    private void getIslandSize(int x, int y, int[][] grid) {

        int n = grid.length;
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        newMap[x][y] = 영역번호;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] 위치 : 상하좌우) {
                int newX = pos[0] + 위치[0];
                int newY = pos[1] + 위치[1];
                if (newX < 0 || newY < 0 || newX >= n || newY >= n) {
                    continue;
                }
                if (grid[newX][newY] == 1 && newMap[newX][newY] == null) {
                    size++;
                    queue.add(new int[]{newX, newY});
                    newMap[newX][newY] = 영역번호;
                }

            }
        }
        map.put(영역번호, size);
        영역번호++;
    }

    public static void main(String[] args) {
        Solution0802 solution0802 = new Solution0802();

        // int[][] grid = {{1,1},{0,1}};
        //int[][] grid = {{1, 1, 0, 0, 1}, {1, 1, 0, 0, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}};
        int[][] grid = {{0,0},{0,0}};

        System.out.println(solution0802.largestIsland(grid));
    }
}

/**
 * 0 0 0 0
 * 0 1 1 1
 * 0 0 0 0
 * 0 0 0 0  => 4
 * <p>
 * 0 0 0 0
 * 1 1 1 1  -> 3
 * 0 0 0 0 -> !
 * 1 1 1 1  -> 4
 * <p>
 * n n n n
 * n 0 0 0
 * n n n n
 * 1 1 1 1
 * <p>
 * hashmap = {0, 3} {1, 4} => 0(1)
 * => 8
 *
 *  0 0
 *  0 0
 *
 *
 *
 */