package y2022.dec;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/remove-stones-to-minimize-the-total/
public class Solution1228 {

    public int minStoneSum(int[] piles, int k) {
        // minimum possible total number of stones remaining after applying the k operations
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            pq.offer(pile);
        }

        for (int i = 0; i < k; i++) {
            int pile = pq.poll();
            pq.offer((int)(pile - Math.floor(pile / 2)));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

}
