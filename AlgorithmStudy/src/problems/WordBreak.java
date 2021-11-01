package problems;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // catsandog
        // cats, dog, sand, and, cat

        // dp : [c,a,t,s,a,n,d,o,g]
        //    [t,f,f,t,t,f,f,t,f,f]
        //.   [t,]

        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // leetcode , ["leet","code"]
                // l -> x
                // le -> x
                // lee -> x
                // leet -> o
                // TFFFTFFFT

                // catsandog , ["cats","dog","sand","and","cat"]
                // TFFTTFFTFF

                // catsanddog
                // TFFTTFFTFFT
                // T 를 시작점으로 단어가 있는지 확인 단어가 있으면 다음 칸은 T로 빠궈줌 (T를 기준으로 단어를 찾아서), 마지막 칸의 T이면 분절이 가능함.

                // Trie를 이용하면 성능 향상 시킬수 있음

                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
