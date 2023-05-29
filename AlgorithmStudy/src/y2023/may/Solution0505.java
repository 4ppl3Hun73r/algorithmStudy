package y2023.may;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
public class Solution0505 {
    Set<Character> vowels;

    public int maxVowels(String s, int k) {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int vowelCnt = 0;
        int maxVowelCnt = 0;
        int windowSize = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isVowels(arr[i])) {
                vowelCnt++;
            }

            if (windowSize == k) {
                if (isVowels(arr[i - k])) {
                    vowelCnt--;
                }
            } else {
                windowSize++;
            }

            maxVowelCnt = Math.max(maxVowelCnt, vowelCnt);
        }

        return maxVowelCnt;
    }

    private boolean isVowels(char c) {
        return vowels.contains(c);
    }
}
