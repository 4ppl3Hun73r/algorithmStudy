package y2021.aug;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternWordMap = new HashMap<>();
        Map<String, Character> wordPatternMap = new HashMap<>();

        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character p = pattern.charAt(i);
            String word = words[i];

            if (patternWordMap.containsKey(p)) {
                String matchWord = patternWordMap.get(p);
                if (!matchWord.equals(word)) {
                    return false;
                }
            } else {
                if (wordPatternMap.containsKey(word)) {
                    // pattern -> word는 없는데
                    // word에 이미 패틴어 있다?
                    return false;
                }
                patternWordMap.put(p, word);
                wordPatternMap.put(word, p);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
    }
}
