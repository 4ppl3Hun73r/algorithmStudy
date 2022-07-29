package y2022.jul;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-and-replace-pattern/
public class Solution0729 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        /*
        words 중에 pattern 과 동일한 패턴을 가진 word 를 찾아서 반환

        ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
          123   123   122   122   121   111               122
         */
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (checkPattern(word, pattern)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private boolean checkPattern(String word, String pattern) {
        int[] patternMap = new int[26];
        int[] wordPatternMap = new int[26];
        int patternIdx = 1;
        int wordIdx = 1;
        for (int i = 0; i < word.length(); i++) {
            int wordChIdx = word.charAt(i) - 'a';
            int patternChIdx = pattern.charAt(i) - 'a';

            if (patternMap[patternChIdx] == 0) {
                patternMap[patternChIdx] = patternIdx++;
            }
            if (wordPatternMap[wordChIdx] == 0) {
                wordPatternMap[wordChIdx] = wordIdx++;
            }
            
            if (patternMap[patternChIdx] != wordPatternMap[wordChIdx]) {
                return false;
            }
        }
        return true;
    }
}
