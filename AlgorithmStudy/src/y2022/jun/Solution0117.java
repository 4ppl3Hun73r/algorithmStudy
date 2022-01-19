package y2022.jun;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/
public class Solution0117 {
    public boolean wordPattern(String pattern, String s) {
        /*
            pattern : abba
            s(words) : dog cat cat dog : true
                       cat dog dog cat : true
                       dog cat dog cat : false
           pattern -> a-z
         */
        Map<Character, String> patternWordMap = new HashMap<>();
        Map<String, Character> wordPatternMap = new HashMap<>();
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Character patternCh = pattern.charAt(i);
            /*
            a -> dog
            b -> cat
            b -> dog vs cat -> false
             */
            // 등록되어 있으면
            if (patternWordMap.containsKey(patternCh)) {
                String pWord = patternWordMap.get(patternCh);
                if (!pWord.equals(word)) {
                    return false;
                }
            } else {
                // 신규 패턴이면 패턴 맵에 등록하는데
                // 이미 word -> pattern에 등록 되어 있다면
                // abba
                // dog dog dog dog
                if (wordPatternMap.containsKey(word)) {
                    return false;
                }
                // 신규 패턴이면 패턴 맵에 등록
                patternWordMap.put(patternCh, word);
                wordPatternMap.put(word, patternCh);
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        Solution0117 s = new Solution0117();
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
    }
}
