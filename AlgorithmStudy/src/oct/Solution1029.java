package oct;

import model.GridCodec;

import java.util.*;

/*
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Solution1029 {
    public int orangesRotting(int[][] grid) {
        //
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int count = 0;
        boolean flag = true;
        int row = grid.length;
        int col = grid[0].length;

        System.out.println(Arrays.deepToString(grid).replaceAll("],", "\n"));
        while (flag) {
            flag = false;
            List<Pair> pairList = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int val = grid[i][j];
                    if (val == 1) {
                        for (int[] dir : dirs) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x < 0 || y < 0 || x == row || y == col) {
                                continue;
                            }
                            if (grid[x][y] == 2) {
                                pairList.add(new Pair(i, j));
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < pairList.size(); i++) {
                grid[pairList.get(i).x][pairList.get(i).y] = 2;
            }
            System.out.println(Arrays.deepToString(grid).replaceAll("],", "\n"));
            flag = !pairList.isEmpty();
            if (flag) {
                count++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRottingJiho(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int min = 0;
        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int [] dir : dirs) { // 4 -> O(1) MAX O(n + m)
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if (x < 0 || y < 0 || x == row || y == col || grid[x][y] != 1) {
                    continue;
                }

                grid[x][y] = 2;
                queue.add(new int[]{x, y, pos[2] + 1}); // bbb
            }
            min = Math.max(min, pos[2]); //pos[2] => count
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        Solution1029 s = new Solution1029();
        GridCodec c = new GridCodec();

        System.out.println(s.orangesRotting(c.getIntGrid("[[2,1,1],[1,1,0],[0,1,1]]"))); // 4
        System.out.println(s.orangesRotting(c.getIntGrid("[[2,1,1],[0,1,1],[1,0,1]]"))); // -1
        System.out.println(s.orangesRotting(c.getIntGrid("[[0,2]]"))); // 0
    }
}
