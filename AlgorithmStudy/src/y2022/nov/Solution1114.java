package y2022.nov;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class Solution1114 {

    Map<Integer, Integer> unionMap = new HashMap<>();
    int count = 0;

    public int removeStones(int[][] stones) {

        /*
        [[0,0],
         [0,1],
         [1,0],
         [1,2],
         [2,1],
         [2,2]]

         [[0,0],
          [0,2],
          [1,1],
          [2,0],
          [2,2]]

         */
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length - count;
    }

    private int find(int x) {
        if (unionMap.putIfAbsent(x, x) == null) {
            count ++;
        }
        if (x != unionMap.get(x)) {
            unionMap.put(x, find(unionMap.get(x)));
        }
        return unionMap.get(x);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            unionMap.put(x, y);
            count--;
        }
    }
}
