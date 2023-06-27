package y2023.may;

import java.util.Arrays;

// https://leetcode.com/problems/new-21-game/
public class Solution0525 {

    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double s = k > 0 ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            if (i < k) {
                s += dp[i];
            }
            if (i - maxPts >= 0 && i - maxPts < k) {
                s -= dp[i - maxPts];
            }
        }
        System.out.println(Arrays.toString(dp));
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }

    // 5222, 4771, 8583
    public double new21GameTLE(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i - j >= 0 && i - j < k) {
                    dp[i] += dp[i - j] / maxPts;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }


    public double new21GameFail(int n, int k, int maxPts) {
        /*
        리턴값 = n 점 이하일 확률
        k = 17점 이상이면 멈춘다.
        maxPts => [1, maxPts]

        n = 10
        k = 1
        [1, 10]
        ans = 1

        n = 6
        k = 1
        [1, 10]
        ans = 60% => 0.6

        n = 21
        k = 17
        [1, 10]

        0.73278
        [1, 1, 1, 1,1,1,1,1,1,1,1...]

        [16] 1번을 더 뽑는거자나요.
        21까지
        1,2,3,4,5
        6,7,8,9,10 => 50%?

        12 => 10%
        13 => 20%
        14 => 30%
        15 => 40%
        16 => 50%
        0.1, 0.2, 0.3, 0.4, 0.5

        21이 넘어가면 안되는데, 17이 넘으면 더이상 안뽑을 거다.
        한번에 뽑는 건 [1, n] 까지이다.

        26 = 16을 뽑을 확률 * 0.1
        25 = 15을 뽑을 확률 * 0.2
        24 = 14을 뽑을 확률 * 0.3

        dp[1] = 1
        dp[2] = dp[1] + get(1) => 2 * dp[1]
        dp[3] = (dp[1] + dp[2]) + (dp[2] + dp[1]) => 2 * (dp[2] + dp[1])
        dp[4] = (dp[1] + get(3)) + (dp[2] + get(2)) + (dp[3] + get[1])
              = (dp[1] + dp[3]) + (dp[2] + dp[2]) + (dp[3] + dp[1]) => 2 * sum(dp[1] ~ dp[3])

        dp[n] =  2 * sum(dp[1] ~ dp[n-1])
        dp[15] = 2 * sum(dp[1] ~ dp[14])
        n = k +

        maxPtr = 3;

        dp[30] = dp[1] + dp[29] + dp[28] + dp[2] + dp[27] + dp[3] => 2 * dp[
        dp[30] =
        for: (int i = 1; i <= maxPtr; i++) {
            dp[n] += dp[n-i] + dp[i]
        }
        output = dp[k] / dp[k + maxPts]


        1

        1 1
        2


        1 2

        1 1 1
        2 1

        3



        Topic : Math, DP, sliding windows
         */

        long[] dp = new long[k + maxPts + 1];
        for (int i = 1; i < maxPts; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= maxPts; j++) {
                if (i - j >= 0 && i - j < k) {
                    dp[i] += dp[i - j];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return  (double)(dp[n]) / (double)dp[k - 1 + maxPts];
    }

    public static void main(String[] args) throws Exception {
        Solution0525 s = new Solution0525();

        System.out.println(s.new21Game(21, 17, 10));
        System.out.println(s.new21Game(6, 1, 10));
    }
}
