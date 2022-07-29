package y2022.jul;

// https://leetcode.com/problems/valid-anagram/
public class Solution0728 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
