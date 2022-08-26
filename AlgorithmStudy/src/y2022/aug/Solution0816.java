package y2022.aug;

import java.util.Arrays;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class Solution0816 {
    public int firstUniqChar(String s) {
        /*
        Given a string s, find the first non-repeating character in it and return its index.
        If it does not exist, return -1.

        loveleetcode
        ^   ^
         ^       ^
         */
        int[] map = new int[26];
        Arrays.fill(map, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map[ch - 'a'] > -1) {
                map[ch - 'a'] = Integer.MIN_VALUE;
            }
            if (map[ch - 'a'] == -1) {
                map[ch - 'a'] = i;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
             if (map[i] >= 0) {
                 ans = Math.min(ans, map[i]);
             }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int firstUniqChar2(String s) {
        int ans = s.length();
        //a
        //
        for(char c = 'a'; c <= 'z'; c++){
            int idx = s.indexOf(c);
            if(idx != -1 && idx == s.lastIndexOf(c)){
                ans = Math.min(ans, idx);
            }
        }
        return ans == s.length() ? -1 : ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0816 s = new Solution0816();

        System.out.println(s.firstUniqChar("leetcode"));

        for (int i = 0; i < 100000; i++) {
            System.out.print('a');
        }
    }
}
