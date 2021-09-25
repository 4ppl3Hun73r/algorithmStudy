package problems;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len == 1) return s;

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            // 한글자는 무조건 회문이므로 true 로 설정
            dp[i][i] = true;
        }

        int longestLen = 1;
        int longestIndex = 0;
        for (int i = len - 1; i >= 0; i--) {
            // xabax
            for (int l = 1; l < len - i; l++) {
                int j = i + l;
                // 길이가 1일떄는 따로 처리해줘야함
                if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && longestLen < j - i + 1) {
                    longestLen = j - i + 1;
                    longestIndex = i;
                }
            }
        }

        return s.substring(longestIndex, longestIndex + longestLen);
    }

    /*
    aba
    xabax
    xabay
    xxxxxxxxababbbbbx
    ^               ^
     ^             ^
     ^            ^

    dp[0][0] => 회문
    dp[0][1] => 회문
    dp[0][2] => 회문
    dp[0][3] => 회문
    dp[i][j] 가 회문이면 dp[i + 1][j - 1] 회문 => dp[i + n][j - n] 도 회문이 된다.
    즉 dp[i]j] = dp[i + 1][j - 1] && s[i] == s[j] 로 구분이 가능하다.
    dp[i][i] = 길이 1이므로 무조건 회문의로 볼수 있으며 이를 통해서 회문의 여부를 확인 할수 있다.


     */



}
