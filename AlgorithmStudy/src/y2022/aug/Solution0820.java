package y2022.aug;

// https://leetcode.com/problems/minimum-number-of-refueling-stops/
public class Solution0820 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        /*
            target 길이 만큼 이동
            fuel 만큼 이동 가능

            stations = [위치, 연료] 를 가지고 있음

            최소한으로 들려야 하는 station 수는?

            NOTE : 위치(target, stations)에 0 으로 떨어져도 됨


            dp[i] = i번 정차로 도달 할 수 있는 가장 긴 위치

         */

        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;


        for (int i = 0; i < stations.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;

    }
}