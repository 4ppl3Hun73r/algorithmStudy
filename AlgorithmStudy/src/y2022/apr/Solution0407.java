package y2022.apr;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight
public class Solution0407 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            //System.out.println(queue);
            int y = queue.poll();
            int x = queue.poll();

            if (x != y) {
                queue.add(y - x);
            }
        }

        if (queue.size() == 0) {
            return 0;
        }

        return queue.poll();
    }
}
