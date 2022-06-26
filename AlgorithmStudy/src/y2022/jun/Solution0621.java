package y2022.jun;

import java.util.PriorityQueue;

// https://leetcode.com/problems/furthest-building-you-can-reach/
public class Solution0621 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        /*
        0 -> heights.length 로 이동

        heights[i] >= heights[i - 1] 이면 이동 가능
        반대라면 bricks or ladders 를 이용해서 이동 가능
        bricks 는 heights[i - 1] - h[i] 만큼 이용 해야 하며
        ladders 는 하나 사용 시 이동 할 수 있음
         */

        int ans = 0;
        PriorityQueue<Integer> ladderPQ = new PriorityQueue<>();
        for (; ans < heights.length - 1; ans++) {
            int left = heights[ans];
            int right = heights[ans + 1];

            if (left >= right) {
                continue;
            }
            int needBricks = right - left;
            ladderPQ.offer(needBricks); // 일단 사다리를 먼저 사용한다고 가정

            if (ladderPQ.size() > ladders) {
                // 모든 사다리를 다 사용했다면 가장 작은 사다리를 bricks 로 변경
                int b = ladderPQ.poll();
                bricks -= b;
            }

            if (bricks < 0) { // 가장 작은 사다리를 사용했는데 남는 bricks가 없으면 종료
                break;
            }
        }

        return ans;
    }
}
