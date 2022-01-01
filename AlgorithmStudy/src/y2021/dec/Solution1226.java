package y2021.dec;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class Solution1226 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        for (int[] point : points) {
            queue.add(point);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
