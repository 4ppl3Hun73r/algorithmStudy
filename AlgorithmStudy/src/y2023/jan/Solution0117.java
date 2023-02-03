package y2023.jan;

import java.util.Arrays;

// https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class Solution0117 {

    public int minFlipsMonoIncr(String s) {
        /*
        01010101010 -> 00000011111 000000000 1111111111 -> min
        0101 -> 0001 -> 1번
                0111 -> 1번
                1111 -> 2번
                0000 -> 2번
                0011 -> 2번


        0000110        , one 0 zero 4 , totalZero 5
                         one + (totalZero - zero) = 1

        0000 -> 0이 4개

        countZero = 1;
        flipOne = 0;

        totalZero 6
        (totalZero - countZero) 5

        countZero = 4
        flipOne = 1

        0000110

        dp[i][0] = 뒤집었을때
        dp[i][1] = 안뒤집었을때

        00110

        dp1 =
        dp2 =

      마지막이 0으로 끝나거
      마지막이 1로 끝나거나

      0000
      0000 + 0 or 1

      0 0 1



      dp[0][0] = 0을 최소한으로 뒤집은 값
      dp[0][1] = 1을 최소한으로 뒤집은 값

      dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]
      dp[i][1] =

      answer[i] = Math.min(dp[i][0], dp[i][1])


        00110 -> 답은 1이에요. 마지막 0을 뒤집으면 되는 거에요.
          ^
        0 을 봐요.
        0을 뒤집는 경우와, 1을 뒤집는 경우가 생깁니다.
        0 을 봤을때
        0을 뒤집는 경우와, 1을 뒤집는 경우가 생기는데요.

        flipZero = 2, flipOne = 0; flip = 2

        flipZero = 2, flipOne = 1; flip = 1 math.min(z, o)

        flipZero = 2, flipOne = 2; flip = 2

        flipZero = 3, flipOne = 2; flip = 2 -> X

        00110
        ^

        0 -> 으로 끝
        1 -> 1로 끝

        dp[0][0] = 0
        dp[0][1] = 1
        flip = 0,

        dp[1][0] = dp[0][0] + 0 // 0
        dp[1][1] = ath.min(dp[0][0], dp[0][1]) + 1; // 1
        flip = 0;

        dp[2][0] = dp[1][0] + 1;
        dp[2][1] = Math.min(dp[1][0], dp[1][1]) + 0; // 0
        flip = 0;

        dp[3][0] = dp[2][0] + 1 // 2
        dp[3][1] = Math.min(dp[2][0],dp[2][1]) + 0 // 0
        flip = 0;

        dp[4][0] = dp[3][0] + 0 // 2
        dp[4][1] = Math.min(dp[3][0], dp[3][1]) + 1 // 1
        flip = 1;

        dp[i][0] = dp[i-1][0] + c == 0? 0 : 1;
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + c == 1 ? 0 : 1;

        min(dp[N][0], dp[N][1])

        1
         */
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            dp[i][0] = dp[i-1][0] + (c == '0' ? 0 : 1);
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + (c == '1' ? 0 : 1);

        }

        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        return Math.min(dp[n - 1][0], dp[n - 1][1]);

    }

    public static void main(String[] args) throws Exception {
        Solution0117 s = new Solution0117();

        System.out.println(s.minFlipsMonoIncr("00110"));
    }
}
