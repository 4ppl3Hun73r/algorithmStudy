package y2023.mar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-cost-for-tickets/
public class Solution0328 {
    public int mincostTickets(int[] days, int[] costs) {
        /*
        days 값을 여행 하려고함
        costs[0] = 1일 티켓
        costs[1] = 7일 티켓
        costs[2] = 30일 티켓

        dp 문제인것 같은데....

        dp[0][0] = 1일 티켓
        dp[0][1] = 7일 티켓
        dp[0][2] = 30일 티켓 => 30일 검사?

        일자 배열이 있고 이 일자배열은 여행 금액의 최소값이 들어 있음

        1,4,6,7,8,20, 2,7,15

        [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
           ^     ^   ^ ^ ^                       ^
           2     7                               2


        minCosts[i] = min(minCost[i + 1] + costs[0], minCosts[i + 7] + costs[1], minCosts[i + 30] + costs[3])
                          재귀적으로 따라가기 때문에 N일 연속 티켓 구매 가격이라 볼 수 있음
                                                     7일 가격이 N일 연속을 포함
                                                                                 30일 가격이 N일 연속을 포함
         */

        Integer[] minCosts = new Integer[365 + 1]; // 최대 365일

        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }

        int ans = helper(1, daySet, costs, minCosts);

        System.out.println(Arrays.toString(minCosts));


        return ans;

    }

    private int helper(int day, Set<Integer> daySet, int[] costs, Integer[] minCosts) {
        if (day > 365) {
            return 0;
        }

        if (minCosts[day] != null) {
            return minCosts[day];
        }

        int ans = 0;

        if (daySet.contains(day)) {

            ans = Math.min(helper(day + 1 ,daySet, costs, minCosts) + costs[0],
                    Math.min(helper(day + 7 ,daySet, costs, minCosts) + costs[1], helper(day + 30 ,daySet, costs, minCosts) + costs[2]));

        } else {
            ans = helper(day + 1, daySet, costs, minCosts);
        }

        return minCosts[day] = ans;

    }


    public static void main(String[] args) {


        Solution0328 s = new Solution0328();

        System.out.println(s.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }
}
