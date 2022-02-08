package y2022.feb;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-difference/
public class Solution0207 {
    public char findTheDifference(String s, String t) {
        char[] map = new char[26];

        for(char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
        }

        // xor == +, - => 0
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return (char)('a' + i);
            }
        }

        return 'a';
    }

    public char findTheDifferenceBit(String s, String t) {
        int diff = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            diff = diff ^ s.charAt(i) ^ t.charAt(i);
        }
        diff = diff ^ t.charAt(i);

        return (char) diff;
    }

    public char findTheDifferenceSort(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return tArr[i];
            }
        }

        return tArr[t.length() - 1];
    }
}
