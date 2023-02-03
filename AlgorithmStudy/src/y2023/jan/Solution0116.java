package y2023.jan;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class Solution0116 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*

         |------|     |---------e  |------------|  |--------------|
                  |-|
              |----------|
      |-|
       |------------------------------------------------------------|  |---|
         */
        if (intervals.length == 0) {
            return new int[][]{
                    newInterval
            };
        }

        List<int[]> list = new ArrayList<>(intervals.length);
        boolean insert = false;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // 비교하는 작업을 하고
            if (newInterval[0] > end) {
                list.add(new int[]{start, end});
                continue;
            }

            if (!insert && newInterval[0] < start) {
                if (newInterval[1] < start) {
                    list.add(newInterval);
                    insert = true;
                } else {
                    start = newInterval[0];
                }
            }

            if (!insert && newInterval[0] <= end) {
                insert = true;
                end = Math.max(newInterval[1], end);
                for (int j = i + 1; j < intervals.length; j++, i++) {
                    if (end < intervals[j][0] ) {
                        break;
                    }
                    if (end <= intervals[j][1]) {
                        end = intervals[j][1];
                    }
                }
            }

            list.add(new int[]{start, end});
        }

        if (!insert) {
            list.add(newInterval);
        }


        return list.toArray(new int[][]{});
    }

}
