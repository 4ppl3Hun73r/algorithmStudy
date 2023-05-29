package y2023.may;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class Solution0528 {
    public int minCost(int n, int[] cuts) {

        /*
        길이 n 의 자가 있다.
        cuts 의 위치를 잘라야 한다.

        cost 는 해당 위치를 자르는 순간 자의 길이이다.

        자르는 순서는 얼마든지 변경 가능하다.

        2 <= n <= 10^6
        1 <= cuts.length <= min(n - 1, 100)
        1 <= cuts[i] <= n - 1
         */

        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
        newCuts[newCuts.length - 1] = n;
        Arrays.sort(newCuts);

        Integer[][] memo = new Integer[newCuts.length + 1][newCuts.length + 1];

        return minCost(newCuts, 0, newCuts.length - 1, memo);
    }

    private int minCost(int[] cuts, int left, int right, Integer[][] memo) {

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        if (left + 1 == right) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int cost = (cuts[right] - cuts[left]);
        for (int i = left + 1; i < right; i++) {
            result = Math.min(
                    result,
                    minCost(cuts, left, i, memo) + minCost(cuts, i, right, memo) + cost
            );
        }
        return memo[left][right] = result;

    }

    public static void main(String[] args) {
        Solution0528 s = new Solution0528();

        System.out.println(s.minCost(7, new int[]{1,3,4,5}));
    }

}
