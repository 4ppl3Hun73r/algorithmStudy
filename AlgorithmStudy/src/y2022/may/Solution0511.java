package y2022.may;

// https://leetcode.com/problems/count-sorted-vowel-strings/
public class Solution0511 {
    public int countVowelStrings(int n) {
        /*
        "a","e","i","o","u" 로 n len 의 조합의 수
         lexicographically sorted 되어야함

         "aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"

         5 + 4 + 3 + 2 + 1

         a e i o u
         aa ae ai ao au -> n[1] * 5
         ee ei eo eu n[1] * 4
         ii io iu n[1] * 3
         oo ou n[1] * 2
         uu n[1] * 1

         aaa aae aai aao aau aee aei aeo aeu ... => 앞의 모든 결과에 a 붙이기
         eee eei eeo eeu eii ... => a로 만든 문자열을 제외하고 모두 e 붙이기
         ...


         */

        int[][] dp = new int[n + 1][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][2] = dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][3] + dp[i - 1][4];
            dp[i][4] = dp[i - 1][4];
        }

        return dp[n][0];
    }
}
