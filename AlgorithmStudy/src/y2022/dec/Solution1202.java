package y2022.dec;

import java.util.Arrays;

// https://leetcode.com/problems/determine-if-two-strings-are-close/
public class Solution1202 {
    public boolean closeStrings(String word1, String word2) {
        /*
        1. 두개의 char swap
        2. 모든 두개의 char 를 변화

        word1 == word2 같은지
        abc
        bca

        cabbba
        abbccc

        aabbbc
        abbccc

        [2,3,1,0,0,0] -> 1,2,3
        [1,2,3,0,0,0] -> 1,2,3

        "uau"
        "ssx"
         */

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            char w1 = word1.charAt(i);
            char w2 = word2.charAt(i);

            map1[w1 - 'a']++;
            map2[w2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            /*
            한쪽이 0이면 다른쪽도 0 이어야함
            한쪽이 0인데 다른쪽이 0이 아니면 false
             */
            if (map1[i] == 0 && map2[i] != 0) {
                return false;
            }
            if (map2[i] == 0 && map1[i] != 0) {
                return false;
            }
        }

        Arrays.sort(map1);
        Arrays.sort(map2);

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }

        return true;

    }
}
