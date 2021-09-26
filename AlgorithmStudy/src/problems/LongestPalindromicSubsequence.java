package problems;

// https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int result = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
/*
 bbbab
 -> a 제로, bbbb 가 가장 긴것 4 반환

 가장 긴 회문을 만들어야 한다.
 가장 작은 회문에서 확장?
 하나씩 지워가면서 만들기?
 dp[i][j] -> i ~ j 사이에서의 가장 긴 회문의 길이
 dp[i][j] -> dp[i+1][j-1] + 2 => 한줄 적은것에서 + 2 할수 있음
 dp[n][n] = 1 -> 이건 무조건 회문
 dp[0][1] -> dp[1][0] + 2 -> X
 dp[0][2] -> dp[1][1] + 2 -> 0 , ex) bbb -> s[0] == s[2] -> dp[1][1] + 2
                                     abc -> s[0] != s[2] -> dp[1][1]
                                     abb or bba -> s[0] != s[2] -> max(dp[0][1], dp[1][2]) -> 위랑 조건 통합 가능, max(1, 1) 이니까.
 */
