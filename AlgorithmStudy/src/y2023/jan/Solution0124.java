package y2023.jan;

import model.GridCodec;

import java.util.*;

// https://leetcode.com/problems/snakes-and-ladders/
public class Solution0124 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Map<Integer, Integer> ladders = new HashMap<>();
        boolean direction = true;
        int idx = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (direction) {
                for (int j = 0; j < n; j++, idx++) {
                    if (board[i][j] != -1) {
                        ladders.put(idx, board[i][j]);
                    }
                }
            } else {
                for (int j = n - 1; j >= 0; j--, idx++) {
                    if (board[i][j] != -1) {
                        ladders.put(idx, board[i][j]);
                    }
                }
            }
            direction = !direction;
        }


        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        int[] visited = new int[(n * n) + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;

        int maxRoll = Math.min(6, n * n);
        System.out.println(ladders);
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);

            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                int nextStep = visited[pos] + 1;

                for (int roll = 1; roll <= maxRoll; roll++) {
                    int nexPos = pos + roll;
                    if (ladders.containsKey(nexPos)) {
                        nexPos = ladders.get(nexPos);
                    }
                    if (nexPos <= n * n && visited[nexPos] == -1) {
                        queue.offer(nexPos);
                        visited[nexPos] = nextStep;
                    }
                }
            }
        }

        return visited[n * n];
    }

    /*
    [[-1,11,6,-1],
     [-1,15,16,-1],
     [-1,7,-1,8],
     [-1,-1,-1,8]]

     */

    public static void main(String[] args) {
        Solution0124 s = new Solution0124();
        GridCodec g = new GridCodec();

        //System.out.println(s.snakesAndLadders(g.getIntGrid("[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]")));
        System.out.println(s.snakesAndLadders(g.getIntGrid("[[-1,11,6,-1],[-1,15,16,-1],[-1,7,-1,8],[-1,-1,-1,8]]")));
    }
}
