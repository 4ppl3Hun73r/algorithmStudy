package y2022.aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
public class Solution0813 {
    public List<Integer> findSubstring(String s, String[] words) {
        // sliding window?
        /*
         barfoofoobarthefoobarman
        [         ]

        [foo, bar, the]
         */
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        Map<String, Integer> wordCntMap = new HashMap<>();
        for (String word : words) {
            wordCntMap.put(word, wordCntMap.getOrDefault(word, 0) + 1);
        }
        int slideLen = wordLen * words.length;
        int end = slideLen;
        for (int i = 0; i <= s.length() - slideLen; i++) {
            String substr = s.substring(i, i + slideLen);
            //System.out.println(substr);

            boolean check = true;
            HashMap<String, Integer> copyMap = new HashMap<>(wordCntMap);
            //System.out.println(copyMap);
            for (int j = 0; j < words.length; j++) {
                String ss = substr.substring(wordLen * j, (wordLen * j) + wordLen);
                //System.out.println(ss);
                if (copyMap.getOrDefault(ss, 0) == 0) {
                    check = false;
                    break;
                }
                copyMap.put(ss, copyMap.get(ss) - 1);
            }
            if (check) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution0813 s = new Solution0813();

        //System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        //System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));

        for (int i = 0; i < 10000; i++) {
            System.out.print('a');
        }
    }
}
