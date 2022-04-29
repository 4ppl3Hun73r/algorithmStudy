package y2022.apr;

import model.GridCodec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/path-with-minimum-effort/
public class Solution0428 {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][] {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int min = Integer.MAX_VALUE;
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0, 0, 0}); // maxPath, r, c
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int maxPath = node[0];
            int r = node[1];
            int c = node[2];

            if (r == row - 1 & c == col - 1) {
                min = Math.min(min, maxPath);
            }
            visited[r][c] = true;
            for(int[] dir : dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if( newR < 0 || newC < 0 || newR == row || newC == col || visited[newR][newC]) {
                    continue;
                }

                int maxDiff = Math.max(maxPath,
                        Math.abs(heights[newR][newC] - heights[r][c]));
                queue.add(new int[]{maxDiff, newR, newC});
            }
        }

        return min;
    }


    int min = Integer.MAX_VALUE;
    int[][] dirs = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    int goalY;
    int goalX;

    public int minimumEffortPathDfs(int[][] heights) {
        /*
        heights[row][col]

        (0,0) -> (row - 1, col - 1) 로 이동할때 가장 높이의 차가 작게 이동 할 수 있게
        이동은 상하좌우

        1 2 2
        3 8 2
        5 3 8
         */

        goalY = heights.length;
        goalX = heights[0].length;
        boolean[][] visited = new boolean[goalY][goalX];
        int[][] minPath = new int[goalY][goalX];
        for (int[] ints : minPath) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        minPath[0][0] = 0;
        dfs(heights, visited, minPath, 0, 0, 0);

        return min;
    }

    private void dfs(int[][] heights, boolean[][] visited, int[][] minPath, int row, int col, int pathMax) {
        if (row == (goalY - 1) && col == (goalX - 1)) {
            min = Math.min(min, pathMax);
            System.out.println();
            return;
        }
        System.out.println("row : "+ row + " col :  " + col + " pathMax : " + pathMax +" , min " +min);

        visited[row][col] = true;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextCol < 0 || nextRow == goalY || nextCol == goalX || visited[nextRow][nextCol]) {
                continue;
            }
            int diff = Math.abs(heights[nextRow][nextCol] - heights[row][col]);
            if (minPath[nextRow][nextCol] <= diff) {
                continue;
            }
            minPath[nextRow][nextCol] = diff;

            dfs(heights, visited, minPath, nextRow, nextCol, Math.max(diff, pathMax));
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) throws Exception {
        Solution0428 s = new Solution0428();
        GridCodec gc = new GridCodec();

        System.out.println(s.minimumEffortPath(gc.getIntGrid("[[1,2,2],[3,8,2],[5,3,5]]")));
        //System.out.println(s.minimumEffortPath(gc.getIntGrid("[[10,8],[10,8],[1,2],[10,3],[1,3],[6,3],[5,2]]")));
        //System.out.println(s.minimumEffortPath(gc.getIntGrid("[[8,3,2,5,2,10,7,1,8,9],[1,4,9,1,10,2,4,10,3,5],[4,10,10,3,6,1,3,9,8,8],[4,4,6,10,10,10,2,10,8,8],[9,10,2,4,1,2,2,6,5,7],[2,9,2,6,1,4,7,6,10,9],[8,8,2,10,8,2,3,9,5,3],[2,10,9,3,5,1,7,4,5,6],[2,3,9,2,5,10,2,7,1,8],[9,10,4,10,7,4,9,3,1,6]]")));
        // 5
    }

    /*
        10 8         0  2
        10 8         0  0
        1  2        -1  6
        10 3        -1  1
        1  3        -1  0
        6  3        -1  0
        5  2        -1  1
     */
}
