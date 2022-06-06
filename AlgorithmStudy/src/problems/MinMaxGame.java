package problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/min-max-game/
public class MinMaxGame {
    public int minMaxGame(int[] nums) {


        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            queue.offer(num);
        }

        boolean min = true;
        while (queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();

            if (min) {
                queue.offer(Math.min(a, b));
            } else {
                queue.offer(Math.max(a, b));
            }

            min = !min;
        }


        return queue.poll();
    }
}
