package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(intervals));

        for (int i = 0; i < intervals.length; i++) {
            int[] merge = new int[]{intervals[i][0], intervals[i][1]};
            for (int j = i; j < intervals.length; j++) {
                if (isMergeable(merge, intervals[j])) {
                    i = j;
                    merge[0] = Math.min(merge[0], intervals[j][0]);
                    merge[1] = Math.max(merge[1], intervals[j][1]);
                }
            }
            list.add(merge);
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private boolean isMergeable(int[] a, int[] b) {
        // [1, 2], [2, 3] or [1, 3] [2, 3]
        /*
           [1, 10]
              [10, 13]
            [2, 9]
         */
        if (a[0] <= b[0] && b[0] <= a[1]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(
            new int[][]{
                    new int[]{1,3},
                    new int[]{2,6},
                    new int[]{8,10},
                    new int[]{15,18}
            }
        )));
    }

}
