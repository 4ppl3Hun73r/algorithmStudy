package y2022.aug;


import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-morse-code-words/
public class Solution0817 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        Set<String> morseCodeSet = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.delete(0, sb.length());

            for (int i = 0; i < word.length(); i++) {
                sb.append(morseCode[word.charAt(i) - 'a']);
            }

            morseCodeSet.add(sb.toString());
        }

        return morseCodeSet.size();
    }
}
