package aug;


import java.util.Arrays;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3870/
public class Solution0806 {

    public boolean stoneGame(int[] piles) {
        int N = piles.length; // 4

        // fibo(1) + fibo(2) + fibo(3) =>

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]]. (one based array)
        // [5,3,4,5]
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size) {
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1; // i  =0 , size = 1, j = 0  -> i = 1, size 1
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    // alex 턴
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                //
                else
                    // -5 + 0, -5 + 0
                    // lee 턴
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);


                System.out.println();
                System.out.println(Arrays.deepToString(dp).replace("],", "]\n"));
                System.out.println();
            }
        }
        // dp(i, j) => i ~ j 가 남아있을때 alex가 얻을 수 있는 최대 점수
        // score is piles[i] + dp(i + 1, j) or piles[j] + dp(i, j - 1]
        // [5,3,4,1] => 5 + dp([3,4,5]), or 1 + dp([5,3,4])
        /*
         * dp(1,1) =>
         */

       /* -> j
      i  [0,0,0,0,0,0]
         [0,-5,0,0,0,0]
         [0,0,0,0,0,0]
         [0,0,0,0,0,0]
         [0,0,0,0,0,0]
         [0,0,0,0,0,0]
*/
        return dp[1][N] > 0; //=> // dp(1, 4)
    }
    public boolean stoneGame2(int[] piles) {
        int alexSum = 0;

        // [5, 3, |  4, 5 ] =>
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        for (int i = 0; i < piles.length / 2; i++) {
            alexSum += Math.max(piles[i], piles[piles.length - 1 - i]);
        }
        return alexSum > sum / 2; // true ->

        // [5, 100, 4, 3] => 5 => 100 => 3
        // i + i +1 > j + j - 1 => j
        // i + i + 1 < j + j - 1 => i
        // return alexSum > leeSum;
    }


    public static void main(String[] args ){
        Solution0806 s = new Solution0806();
        s.stoneGame(new int[]{5,3,4,5});
    }


    /*

        boolean result = true;

        // 어떻게든, Alex / Lee -> 늘 최선으로 한다.

        // [5,3,4,5]
        // [5,100,4,5]
        // [5,101,1,2,101,1]
        // [5,101,9999,2,100001,1,1,1]

        // [1,2,3,4,5,6,7,9,8,

        // [3, 100, 10, 4]
        // A : 4
        //   : 3 -> 10
        // L : 4 -> 2

        return result;

    }*/
}
