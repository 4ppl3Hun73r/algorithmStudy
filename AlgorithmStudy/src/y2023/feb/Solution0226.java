package y2023.feb;

// https://leetcode.com/problems/edit-distance/
public class Solution0226 {
    public int minDistance(String word1, String word2) {

        // word1 -> word2 로 변경하는 최소한의 수를 찾아라.
        // insert , delete, replace

        Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];

        return minDistance(word1, word2, word1.length(), word2.length(), dp);

    }

    private int minDistance(String word1, String word2, int w1Index, int w2Index, Integer[][] dp) {
        // 한쪽이 0 되면 나머지 insert step만 남음
        if (w1Index == 0) {
            return w2Index;
        }
        if (w2Index == 0) {
            return w1Index;
        }

        if (dp[w1Index][w2Index] != null) {
            return dp[w1Index][w2Index];
        }

        if (word1.charAt(w1Index - 1) == word2.charAt(w2Index - 1)) {
            return dp[w1Index][w2Index] = minDistance(word1, word2, w1Index - 1, w2Index - 1, dp);
        }
        int insert = minDistance(word1, word2, w1Index, w2Index - 1, dp);
        int delete = minDistance(word1, word2, w1Index - 1, w2Index, dp);
        int replace = minDistance(word1, word2, w1Index - 1, w2Index - 1, dp);

        return dp[w1Index][w2Index] = Math.min(insert, Math.min(delete, replace)) + 1;
    }
}
