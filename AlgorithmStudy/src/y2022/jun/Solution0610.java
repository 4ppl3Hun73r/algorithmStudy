package y2022.jun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Solution0610 {
    public int lengthOfLongestSubstring(String s) {
        /*
        문자가 반복되지 않는 가장 긴 문자열의 길이
        s consists of English letters, digits, symbols and spaces.

        0 <= s.length <= 5 * 10000
        pwwkepw
          ^ ^
        substring : pw / wke /

        p 가 앞에 있나?
        w 이미 앞에 있었나?
          w가 앞에 있었으면 -> 조건에서 탈락 -> pw -> 가장 긴 문자열의 후보가 된다.
        */
        int ans = 0;
        Set<Character> characterSet = new HashSet<>();
        int length = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterSet.contains(c)) {
                ans = Math.max(ans, length);
                length = 0;
                i = getIndexOf(s, c, idx);
                idx = i+1;
                characterSet.clear();
                continue;
            } else {
                length++;
            }
            characterSet.add(c);
        }
        ans = Math.max(ans, length);

        return ans;
    }

    private int getIndexOf(String s, char c, int start) {
        for(int i = start; i < s.length(); i++) {
            if(s.charAt(i) == c)
                return i;
        }
        return 0;
    }

    public int lengthOfLongestSubstring2(String s) {

        int ans = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0;
        // abba
        // a - 0
        // b - 2
        // bacda
        //   ^
        // abba
        //   ^
        // aab
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexMap.containsKey(c)) {
                ans = Math.max(ans, i - start);
                start = Math.max(start, charIndexMap.get(c) + 1);
            }
            charIndexMap.put(c, i);
        }
        ans = Math.max(ans, s.length() - start);

        return ans;
    }
    //"abcabcbb"

    public int lengthOfLongestSubstring1(String s) {
        int max = 0;

        Set<Character> a = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            int j = i;
            while(j < s.length()) {
                char c = s.charAt(j);
                if(a.contains(c)) {

                    break;
                } else {
                    a.add(c);
                }
                j++;
            }
            if (max < j-i) {
                max = j-i;
            }
            a = new HashSet<>();
        }

        return max;
    }
}
/*
   dvdf

   pwwkepw


 */

// input : "dvdf"
//           s
// output : 2