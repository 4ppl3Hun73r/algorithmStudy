package y2023.apr;

import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/
public class Solution0424 {
    public int lastStoneWeight(int[] stones) {
        /*

        무거운 돌 두개를 충돌시켜서 부순다.
        무게가 같다 0
        무게가 다르다 x - y (x > y)
        남은 돌들을 가지고 위에 반복
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            if (y != x) {
                pq.add(y-x);
            }
        }

        if (pq.isEmpty()) {
            return 0;
        }

        return pq.poll();
    }
}
