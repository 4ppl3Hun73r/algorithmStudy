package y2023.may;


// https://leetcode.com/problems/solving-questions-with-brainpower/
public class Solution0512 {
    public long mostPoints(int[][] questions) {
        /*
        questions[0] => 점수
        questions[1] => brainPower (문제를 풀면 해당 값만큼 스킵)

        dp[n] => N번째 문제를 풀었을때 최대 점수

        dp[n] = 현재문제를 풀었을때랑, 안풀었을때 비교

        [[3,2],[4,3],[4,4],[2,5]]
          ^                  ^

        dp[3] = 2;
        dp[2] = Math.max(4, dp[6] + 4) = 4;
        dp[1] = Math.max(4, dp[4] + 4) = 4;
        dp[0] = Math.max(3, dp[3] + 3) = 5;
         */
        long[] dp = new long[questions.length];

        dp[questions.length - 1] = questions[questions.length - 1][0];
        for(int i = questions.length - 2; i >=0; i--) {
            int pos = i + questions[i][1] + 1;
            long value = questions[i][0];
            if (pos < questions.length) {
                value += dp[pos];
            }
            dp[i] = Math.max(dp[i + 1], value);
        }

        return dp[0];
    }
}