package y2022.feb;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/remove-covered-intervals/
public class Solution0220 {
    public int removeCoveredIntervals(int[][] intervals) {
        /*
        정렬하기
        1, 4
        3, 6
        2, 8


        1------4
           2-----------8
             3-----6
             3------------9
           27

        1------4
             3-----6
           2-----------8

           2-----------8
        1------4
              3-----6
         */


        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
        comparator = comparator.thenComparing((a, b) -> b[1] - a[1]);
        Arrays.sort(intervals, comparator);

        int[] comp = intervals[0];
        int result = intervals.length;
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            while (comp[0] <= next[0] && next[1] <= comp[1]) {
                result --;
                i++;
                if (i == intervals.length) {
                    break;
                }
                next = intervals[i];
            }
            comp = next;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution0220 s = new Solution0220();

        System.out.println(s.removeCoveredIntervals(new int[][] {
                {1,4},
                {3,6},
                {2,8},
                {1,100}
        }));
    }

}
