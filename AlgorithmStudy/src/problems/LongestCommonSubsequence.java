package problems;

// https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        /*
        dp[i][j] = text[0...i] & text[0...j] longest subsequence
        DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise


        abcde, ace

        dp[0][0] = text1[0] & text2[0] = 1
        dp[0][1] = text1[0] & text2[0..1] = 1
        dp[1][0] = text1[0..1] & text2[0] = 1
        dp[1][1] = text1[0..1] & text2[0..1] = 1
        dp[2][0] = text1[0..2] & text2[0] = 1
        ap[0][2] = text1[0] & text2[0..2] = 1
        dp[2][2] = text1[0..2] & text[0..2] = 2
        ...
        dp[4][2] = text1[0..4] & text[0..2] = 3

        dp[i][j] = dp[i - 1][j - 1] + 1 if text1[i] == text2[j]
         */

        // dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
