package y2022.jun;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/short-encoding-of-words/
public class Solution0620 {
    public int minimumLengthEncoding(String[] words) {
        /*
        words 를
        word1#word2#word3# 로 만든다.
        그런데 word1 안에 word2 가 포함된다면 ex) time, me -> ti"me"
        time#word3#
          me#
        으로 축약할 수 있다.

        1 <= words.length <= 2000
        1 <= words[i].length <= 7
        words[i] consists of only lowercase letters.
        word 가 짧아서 문제 없을 듯
         */

        Set<String> set = new HashSet<>(words.length);
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        int ans = 0;
        for (String s : set) {
            ans += s.length() + 1; // word + #
        }


        return ans;
    }
}
