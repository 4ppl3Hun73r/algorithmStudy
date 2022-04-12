package y2022.apr;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/shift-2d-grid/
public class Solution0411 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        /*
        Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
        In one shift operation:
        Element at grid[i][j] moves to grid[i][j + 1].
        Element at grid[i][n - 1] moves to grid[i + 1][0].
        Element at grid[m - 1][n - 1] moves to grid[0][0].
        Return the 2D grid after applying shift operation k times.
         */
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.add(grid[i][j]);
            }
        }
        int cnt = m * n;
        int start = (cnt + k) % cnt;

        while (start-- > 0) {
            queue.offerFirst(queue.pollLast());
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(queue.poll());
            }
            ans.add(row);
        }

        return ans;
    }
}
