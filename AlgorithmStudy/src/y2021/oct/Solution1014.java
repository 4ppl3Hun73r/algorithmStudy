package y2021.oct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/perfect-squares/
public class Solution1014 {

    public int numSquaresDP(int n) {
        // n = 1, return 1 -> 1
        // n = 2, return 2 -> 1 + 1
        // n = 3, return 3 -> 1 + 1 + 1
        // n = 4, return 1 -> 2
        // n = 5, return 2 -> 2 + 1 -> min(dp[4] + dp[1 = (5 - 4)] , dp[3] + dp[2])
        // n = 6, return 3 -> 2 + 1 + 1 -> dp[4] + dp[2]
        // n = 7, return 4 -> 2 + 1 + 1 + 1 -> dp[4] + dp[3]
        // n = 8, return 2 -> 2 + 2 -> dp[4] + dp[4]
        // n = 9, return 1 -> 3
        // n = 10, return 2 -> 3 + 1 -> dp[9] + dp[1]
        // n = 11, return 3 -> 3 + 1 + 1 -> dp[9] + dp[2]
        // n = 12, return 4 -> 3 + 1 + 1 + 1 Wrong Answer, 2 + 2 + 2 <==

        /*
         dp[0] = 1
         dp[1] = 1
         dp[2] = 2
         dp[3] = 3
         dp[4] = 1
         dp[5] = dp[4] + dp[1]
         dp[6] = dp[4] + dp[2]
         dp[7] = dp[4] + dp[3]
         dp[8] = dp[4] + dp[4]
         dp[9] = 1
         dp[10] = dp[9] + dp[1] // (dp[5] + dp[4])
         dp[12] = dp[9] + dp[3] -> 4 // 4 + 4 + 4 -> 9 + 1 + 1 + 1
         dp[12] = dp[9] + dp[3], dp[4] + dp[8], dp[1] + dp[11]

         dp -> 해당 n 값에서의 min이고
         dp[완전제곱수] = 1
         dp[n] = for (dp[완전제곱수 < n) 찾기  <--
         */

            if (n < 4) {
                return n;
            }

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = dp[1] + 1;
            dp[3] = dp[2] + 1;


            for (int i=4; i<(n + 1); i++) {
                int sqrt = (int)Math.sqrt(i);
                if (i - (sqrt * sqrt) == 0) {
                    dp[i] = 1; //
                } else {
                    dp[i] = Integer.MAX_VALUE;
                    for(int j = 1; j * j < i; j++) {
                        int square = j * j;
                        dp[i] = Math.min(dp[i], dp[square] + dp[i - square]);
                    }
                }

            }

            return dp[n];
    }
    public int numSquares(int n) {
        // n = sum(완전제곱수...)
        // 완전제곱수 = 1, 4, 9, 16, 25 ...

        // Math, DP, BFS

        // 12 => 4 + 4 + 4 , 9 + 1 + 1 + 1
        // greedy 로 12가 문제가 됨

        // 29 => 25 + 4
        // 28 =>

        // BFS -> Queue;
        // n <= 1, 4, 9
        // 9 -> 3 -> 1 + 1 + 1
        // 4 ->
        // 1 ->

        List<Integer> perfectSquares = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            perfectSquares.add(i * i);
        }

        Queue<int[]> queue = new LinkedList<>();
        for(Integer perfectSquare : perfectSquares) {
            queue.add(new int[] { n - perfectSquare, 1});
        }

        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            if (t[0] == 0) {
                result = Math.min(result, t[1]);
            } else {
                for(Integer perfectSquare : perfectSquares) {
                    if (perfectSquare <= t[0]) {
                        queue.add(new int[] { t[0] - perfectSquare, t[1] + 1});
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution1014 s = new Solution1014();
        for (int i = 1; i < 10000; i++) {
            System.out.println(i + " : " + s.numSquaresDP(i));
        }
    }
}
