package y2022.oct;


import java.util.Arrays;

// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
public class Solution1016 {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) {
            return -1;
        }
        if (len == d) {
            return Arrays.stream(jobDifficulty).sum();
        }

        /*
        배열을 d 개로 쪼개는 작업
        각 쪼개진 배열의 최대 값의 합이 최소가 되게.
         */
        int[][] dp = new int[len][d + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(d, 0, jobDifficulty, dp);
    }

    private int dfs(int d, int currentLen, int[] jobDifficulty, int[][] dp) {
        int len = jobDifficulty.length;

        if(d == 0 && currentLen == len){
            return 0;
        }
        if(d == 0 || currentLen == len) {
            return Integer.MAX_VALUE;
        }
        if(dp[currentLen][d] != -1) {
            return dp[currentLen][d];
        }

        int curMax = jobDifficulty[currentLen];
        int min = Integer.MAX_VALUE;
        for(int schedule = currentLen; schedule < len; schedule++){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty, dp);
            if(temp != Integer.MAX_VALUE) {
                min = Math.min(min, temp + curMax);
            }
        }

        dp[currentLen][d] = min;

        return dp[currentLen][d];
    }

}
