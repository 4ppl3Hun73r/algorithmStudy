package y2022.oct;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-the-sentence-is-pangram/
public class Solution1017 {

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            set.add((char)('a' + i));
        }

        char[] cArr = sentence.toCharArray();
        for (char c : cArr) {
            set.remove(c);
        }

        return set.isEmpty();
    }

    public boolean checkIfPangramArr(String sentence) {
        int[] alphabet = new int[26];

        char[] cArr = sentence.toCharArray();
        for (char c : cArr) {
            alphabet[c - 'a']++;
        }

        for (int i : alphabet) {
            if (i == 0) {
                return false;
            }
        }

        return true;
    }
}
