package y2022.may;

import model.GridCodec;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class Solution0516 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        int dirs[][] = new int[][] {
                {-1, -1}, {-1,0}, {-1,1},
                {0, -1}, {0,1},
                {1,-1},{1,0},{1,1}
        };
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>(); // x, y, count
        visited[0][0] = true;
        queue.add(new int[]{0,0,1});

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];
            int nextCount = node[2] + 1;

            if(y == n-1 && x == n-1) {
                return node[2];
            }
            for(int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if( newX < 0 || newY < 0 || newX == n || newY == n || grid[newY][newX] == 1)
                    continue;
                if(visited[newY][newX]) continue;
                visited[newY][newX] = true;

                queue.add(new int[]{newY,newX, nextCount});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Solution0516 s = new Solution0516();
        GridCodec g = new GridCodec();

        System.out.println(s.shortestPathBinaryMatrix(g.getIntGrid("[[0,0,0],[1,1,0],[1,1,0]]")));
        System.out.println(s.shortestPathBinaryMatrix(g.getIntGrid("[[1,0,0],[1,1,0],[1,1,0]]")));
    }
}
