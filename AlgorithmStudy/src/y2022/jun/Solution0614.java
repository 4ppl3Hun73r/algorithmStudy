package y2022.jun;

// https://leetcode.com/problems/delete-operation-for-two-strings/
public class Solution0614 {
    public int minDistance(String word1, String word2) {
        /*
        두 글자가 같아 질 수 있는 최소한의 step
        dp 문제
        word1 = "leetcode", word2 = "etco"
        Output: 4

        dp[i] = dp[i - 1] + ???

         leetcode
         etco
         1
          3 or 2
           4 or 2
            .....

         dp[0] = 1, 2, 7
         dp[1] =

         dp[][] = new dp[word1.length + 1][word2.length + 1]
         dp[i][j] -> 지워야 되는 최소한의 수 (minDistance)
           - l e e t c o d e
         - 0 1 2 3 4 5 6 7 8
         e 1 2 1 2 3 4 5 6 7
         t 2 3 2 3 2 3 4 5 6
         c 3 4 3 4 3 2 3 4 5
         o 4 5 4 5 4 3 2 3 4

       dp[0][c] = c
       dp[r][0] = r
       dp[r][c] = w1 == w2 ? dp[r-1][c-1] : 1 + min(dp[r][c-1], dp[r-1][c])

       dp[r][c] = w1 == w2 ? [r-1][c-1] : [r-1][c-1]+2
                = w1 != w2 ? 1 + min([r][c-1], [r-1][c])

         - s e a
       - 0 1 2 3
       e 1 2 1 2
       a 2 3 2 1
       t 3 4 3 2

         */



        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        //System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));

        for(int i = 1 ; i <= word1.length(); i++) {
            char w1 = word1.charAt(i - 1);
            for(int j = 1; j <= word2.length(); j++) {
                char w2 = word2.charAt(j - 1);

                if (w1 == w2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            //System.out.println(Arrays.deepToString(dp).replaceAll("],", "\n"));
        }


        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) throws Exception {
        Solution0614 s = new Solution0614();

        System.out.println(s.minDistance("eat", "sea"));
    }
}
