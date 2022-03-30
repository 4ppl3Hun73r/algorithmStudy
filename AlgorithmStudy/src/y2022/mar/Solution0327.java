package y2022.mar;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
public class Solution0327 {
    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[1]);
        comparator = comparator.thenComparingInt(o -> o[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);

        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                } else {
                    break;
                }
            }
            queue.add(new int[]{i, cnt});
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }

        return ans;
    }
}
