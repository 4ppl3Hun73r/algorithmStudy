package y2023.apr;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
public class Solution0416 {


    int mod = 1000000007;
    public int numWays(String[] words, String target) {
        /*

        words 를 가지고 target 을 만든다.
        words[n] 중 어디에서든 k 번째 char 하나를 가져 올 수 있지만
        한번 가져오면 k 번째는 사용 못한다.
        다음 k 는 이전 k 보다 커야 한다.

        abba
        baab
       t: bab

          abba
          baab -> b -> a(1) -> b

          abba
          baab -> b -> a(2) -> b

          abba              -> b(2)
          baab -> b -> a(1)

          abba -> b(1)            -> a(2)
          baab ->      -> a(2)

          [a,b][a,b][a,b][a,b]

           bab
           1    1    1
                           1
                1    1     1
           1         1     1
         */

        int k = words[0].length();
        int[][] wordCharMap = new int[k][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                wordCharMap[i][word.charAt(i) - 'a'] ++;
            }
        }

        long[][] dp = new long[target.length() + 1][k + 1];
        for (int i = 0; i <= target.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) count(dp, wordCharMap, target, target.length(), k);

    }

    private long count(long[][] dp, int[][] wordCharMap, String target, int targetPos, int k) {
        if (k == 0) {
            return targetPos == 0 ? 1 : 0;
        }
        if (dp[targetPos][k] != -1) {
            return dp[targetPos][k];
        }

        dp[targetPos][k] = count(dp, wordCharMap, target, targetPos, k - 1);
        if (targetPos > 0) {
            dp[targetPos][k] += wordCharMap[k - 1][target.charAt(targetPos - 1) - 'a'] * count(dp, wordCharMap, target, targetPos - 1, k - 1);
        }
        dp[targetPos][k] %= mod;

        System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        return dp[targetPos][k];
    }

    public static void main(String[] args) {
        Solution0416 s = new Solution0416();

        System.out.println(s.numWays(new String[]{"abba", "baab"}, "bab"));
    }
}
