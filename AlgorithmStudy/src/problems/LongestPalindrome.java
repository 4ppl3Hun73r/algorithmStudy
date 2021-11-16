package problems;

// https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] lowerMap = new int[26];
        int[] upperMap = new int[26];


        for(char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperMap[c - 'A'] ++;
            } else {
                lowerMap[c - 'a'] ++;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += lowerMap[i] / 2 * 2;
            if (count % 2 == 0 && lowerMap[i] % 2 == 1) {
                count++;
            }
            count += upperMap[i] / 2 * 2;
            if (count % 2 == 0 && upperMap[i] % 2 == 1) {
                count++;
            }
        }

        return count;
    }
}

// AAAAAAAaaaaaaabbbc
// AAAaaacaaaAAA