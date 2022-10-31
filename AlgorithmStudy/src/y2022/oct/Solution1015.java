package y2022.oct;

import java.util.Arrays;

// https://leetcode.com/problems/string-compression-ii/
public class Solution1015 {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] cArr = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len + 1][k + 2];

        for (int i = 0; i < len + 1; i++) {
            Arrays.fill(dp[i], len + 1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i - 1][j]);

                int count = 0;
                int del = 0;
                for (int l = i; l <= len; l++) {
                    if (cArr[i - 1] == cArr[l - 1]) {
                        count++;
                    } else {
                        del++;
                    }

                    if (j + del <= k) {
                        int newLen = dp[i - 1][j] + 1;
                        if (count >= 100) {
                            newLen += 3;
                        } else if (count >= 10) {
                            newLen += 2;
                        } else if (count >= 2) {
                            newLen += 1;
                        } else {
                            // newLen = 0;
                        }

                        dp[l][j + del] = Math.min(dp[l][j + del], newLen);
                    } else {
                        break;
                    }
                }
                System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));
            }
        }

        return dp[len][k];
    }

    public static void main(String[] args) {
        Solution1015 s = new Solution1015();

        System.out.println(s.getLengthOfOptimalCompression("aaabcccd", 2));
    }
}
