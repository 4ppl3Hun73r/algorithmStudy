package y2022.nov;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
public class Solution1103 {

    public int longestPalindrome(String[] words) {
        /*
        2개의 문자로 이뤄진 배열
        가장 긴 회문을 만들어라

        "lc","cl","gg"
         lc gg cl
         lc -> cl : pair ->
         gg gg gg gg pair -> gg
         */

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int len = 0;
        for (String key : wordsMap.keySet()) {
            String reverseKey = "" + key.charAt(1) + key.charAt(0);

            if (reverseKey.equals(key)) {
                int value = wordsMap.getOrDefault(key, 0);
                len += (value / 2) * 4;
                wordsMap.put(key, value % 2);
                continue;
            }
            int value = wordsMap.getOrDefault(key, 0);
            int reverseValue = wordsMap.getOrDefault(reverseKey, 0);
            int min = Math.min(value, reverseValue);

            len += min * 4;
            if (min != 0) {
                wordsMap.put(key, value - min);
                wordsMap.put(reverseKey, reverseValue - min);
            }
        }

        for (String s : wordsMap.keySet()) {
            if (s.charAt(0) == s.charAt(1) && wordsMap.get(s) > 0) {
                len += 2;
                break;
            }
        }

        return len;
    }

    public int longestPalindromeArr(String[] words) {
        int counter[][] = new int[26][26];
        int ans = 0;

        for (String w : words)
        {
            int char1 = w.charAt(0) - 'a';
            int char2 = w.charAt(1) - 'a';

            if (counter[char2][char1] > 0) // if there is mirror for the current word
            {
                ans += 4;
                counter[char2][char1]--;
            }
            else
                counter[char1][char2]++; // unpaired words
        }

        for (int i = 0; i < 26; i++)
        {
            if (counter[i][i] > 0) // check if there is any word can be center
            {
                ans += 2;
                break;
            }
        }

        return ans;
    }
    public int longestPalindromeMap(String[] words) {
        HashMap<String, Integer> memo = new HashMap<>();
        int result = 0;
        int sym = 0;
        for (String cur : words) {
            String rev = cur.charAt(1) + "" + cur.charAt(0);
            if (memo.getOrDefault(rev, 0) > 0) {
                result++;
                memo.put(rev, memo.getOrDefault(rev, 0) - 1);
                if (rev.equals(cur)) {
                    sym--;
                }
            } else {
                memo.put(cur, memo.getOrDefault(cur, 0) + 1);
                if (rev.equals(cur)) {
                    sym++;
                }
            }
        }

        return result * 4 + (sym > 0 ? 2 : 0);
    }

    public static void main(String[] args) throws Exception {
        Solution1103 s = new Solution1103();

        System.out.println(s.longestPalindrome(new String[]{"lc","cl","gg","gg"}));
    }

}
