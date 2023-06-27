package y2023.apr;

import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-subsequence/
public class Solution0414 {
    public int longestPalindromeSubseq(String s) {
        /*
        bbab
        bbbbbb

        dp[i][j] = i ~ j 까지 중 가장 긴 회문의 길이?
        dp[i][i] = 1

        [b]bbb[]
        []bbbb[]

          b  b  a  b
        b[1][2][2][3]
        b[ ][1][1][2]
        a[ ][ ][1][*]
        b[ ][ ][ ][1]

        if (s[0] == s[1]) {
            dp[1][0] = dp[i + 1][j - 1] + 2
        } else {
            dp[2][3] = max(dp[2][2], dp[3][3])
            dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])
        }
        if (s[i] == s[j])
            dp[i][j] = dp[i+1][j-1] + 2
        else
            dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j])

        //    i , i+1                  j-1 ,  j

              i,  i+1                         j-1 , j

         */
        // [                   j]

        //dp[0][length]
        //dp[0][1,2,3,4,5,6]
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        //int ans = 0;
        //for (int i = 0; i < n; i++) {
        for (int i = n - 1; i >= 0; i--) {
            /*
            [i j            ]
            [i   j          ]
             */
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }

                // ans = Math.max(ans, dp[i][j]); // == dp[0][n -1]
            }
        }
        /*
        [[1, 2, 2, 3
         [0, 1, 1, 3
         [0, 0, 1, 1
         [0, 0, 0, 1]]

         [[1, 2, 2, 2
          [0, 1, 1, 3
          [0, 0, 1, 1
          [0, 0, 0, 1]]

         */

        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) throws Exception {
        Solution0414 s = new Solution0414();

        System.out.println(s.longestPalindromeSubseq("bbab"));
    }
}
