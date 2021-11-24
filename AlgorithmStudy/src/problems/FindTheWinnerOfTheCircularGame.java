package problems;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-the-winner-of-the-circular-game/
public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        /* member(n) :  1 - 2 - 3 - 4 - 5
           count(k)  :  1   2
           member(n) :  1 - 3 - 4 - 5
           count(k)  :      1   2
           member(n) :  1 - 3 - 5
           count(k)  :  2       1
           member(n) :  3 - 5
           count(k)  :  1   2
           member(n) :  3 is winner
           count(k)  :
         */

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }
}
