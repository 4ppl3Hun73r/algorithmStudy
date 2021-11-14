package problems;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[1]);
        comparator.thenComparingInt(a -> a[0]);
        Arrays.sort(intervals, comparator);
        System.out.println(Arrays.deepToString(intervals));

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= end) end = interval[1];
            else count++;
        }

        return count;

                    // is overlapping?
                    // [[1,2],[2,3],[3,4],[1,3]] -> sort
                    // [[1,2],[1,3],[2,3],[3,4]]


                /*
                1 2 3 4 5 6 7 8 9
                ----------------------------
                |-|     -> 겹침 1
                |---|   -> 겹침 2
                  |-|   -> 겹침 1
                    |-| -> 겹침 0

                1,1,2,3
                2,3,3,4

                1,2
                2,3
                 */
    }



    public static void main(String[] args) throws Exception {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
       /* System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(
                new int[][]{
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{1,3}
                }
        ));*/

        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(
                new int[][]{
                        new int[]{1,100},
                        new int[]{11,22},
                        new int[]{1,11},
                        new int[]{2,12}
                }
        ));

        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(
                new int[][]{
                        new int[]{0,2},
                        new int[]{1,3},
                        new int[]{1,3},
                        new int[]{2,4},
                        new int[]{3,5},
                        new int[]{3,5},
                        new int[]{4,6}
                }
        ));  // 4
        // [0, 2], [1, 3], [2, 4], [3, 5], [4, 6] -> 2개 지움
        //
    }
}
