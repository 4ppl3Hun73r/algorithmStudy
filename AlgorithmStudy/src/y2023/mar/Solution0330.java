package y2023.mar;

import java.util.Arrays;

// https://leetcode.com/problems/scramble-string/
public class Solution0330 {
    public boolean isScramble(String s1, String s2) {

        // 어렵다. 답 보고 일단 제출
        // 답 봐도 이해가 안됨 ㅠ


        /*
        문자열 길이가 1 이면 멈추기

        1보다 크면
         - S 를 랜덤한 길이인 X / Y 로 분해
         - 랜덤으로 교환할지 말지 결정 -> s = x + y => x = y + x 가 될 수 있음
         - x y 에 대해서도 다시 진행

         s1.len == s2.len

         s1을 변환해서 s2와 동일하면 true, 아니면 false
         */

        int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(dp));

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean dp1[] = dp[newLength][i];
                        boolean dp2[] = dp[length - newLength][i + newLength];
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];
                    }
                }
            }
        }


        return dp[n][0][0];
    }

    public static void main(String[] args) throws Exception {
        Solution0330 s = new Solution0330();

        System.out.println(s.isScramble("great", "eatrt"));
    }
}
