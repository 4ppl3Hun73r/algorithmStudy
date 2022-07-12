package problems;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {

        int times = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i : amount) {
            if (i != 0) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                times += pq.poll();
            } else {
                int a = pq.poll() - 1;
                int b = pq.poll() - 1;
                times ++;

                if (a != 0) {
                    pq.offer(a);
                }
                if (b != 0) {
                    pq.offer(b);
                }
            }
        }

        return times;
    }
}
