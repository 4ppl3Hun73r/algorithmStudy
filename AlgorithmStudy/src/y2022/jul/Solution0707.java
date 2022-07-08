package y2022.jul;

// https://leetcode.com/problems/interleaving-string/
public class Solution0707 {
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        s1 과 s2 를 가지고 s3를 만들기

        규칙
        s = s1 + s2 + s3 .. + sn
        t = t1 + t2 + t3 .. + tm
        |n-m| <= 1

        s1 + t1 + s2 + t2 ..
        t1 + s1 + t2 + s2 ..

        재귀? DP

           ' ' a a b c c  (i)
        ' '    T T
         d  F  F T
         b
         b
         c
         a
        (j)


          aadbbcbcac
         t[i + j - 1]

         dp[1][0] = s1[i] == t[0] => T
         dp[0][1] = s2[j] == t[0] => F
         dp[1][1] = (dp[1][0] && t[1] == s2[1]) || (dp[0][1] && t[1] == s1[1])
         dp....
         */
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                // char t = s3.charAt(i + j - 1);
                int k = i + j - 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k);
                } else {
                    dp[i][j] =
                        (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }


        return dp[s1.length()][s2.length()];
    }
}
