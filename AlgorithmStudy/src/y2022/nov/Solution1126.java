package y2022.nov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
public class Solution1126 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        /*
        start, endTime, profit

        최대 이익을 내는 방법?

        dp, binary search, sorting

         */

        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue()) {
                dp.put(job[1], cur);
            }
        }


        return dp.lastEntry().getValue();

    }

    public static void main(String[] args) {
        Solution1126 s = new Solution1126();

        System.out.println(s.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
    }
}
