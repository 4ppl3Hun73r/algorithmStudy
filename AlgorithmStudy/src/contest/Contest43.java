package contest;

import java.util.*;

public class Contest43 {

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int r = grid.length;
        int c = grid[0].length;

        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
        comparator = comparator.thenComparingInt(o -> o[1]);
        comparator = comparator.thenComparingInt(o -> o[2]);
        comparator = comparator.thenComparingInt(o -> o[3]);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int[][] dirs = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                int distance = pos[2];

                int price = grid[pos[0]][pos[1]];
                if (pricing[0] <= price && price <= pricing[1]) {
                    priorityQueue.add(new int[]{distance, price, pos[0], pos[1]});
                }

                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x < 0 || y < 0 || x == r || y == c || visited[x][y] || grid[x][y] == 0) {
                        continue;
                    }
                    queue.add(new int[]{x, y, distance + 1});
                    visited[x][y] = true;
                }

            }

            if (priorityQueue.size() >= k) {
                break;
            }
        }

        while(!priorityQueue.isEmpty()) {
            int[] t = priorityQueue.poll();
            result.add(Arrays.asList(t[2], t[3]));
            if (result.size() == k) {
                break;
            }
        }

        return  result;
    }

    public static void main(String[] args) {
        Contest43 c = new Contest43();

        /*System.out.println(c.highestRankedKItems(new int[][]{
                {1,2,0,1},
                {1,3,0,1},
                {0,2,5,1}
        }, new int[]{2, 5}, new int[] {0, 0}, 3));*/

        System.out.println(c.highestRankedKItems(new int[][]{
                {1,0,1},
                {3,5,2},
                {1,0,1}
        }, new int[]{2, 5}, new int[] {1, 1}, 9));
    }
}
