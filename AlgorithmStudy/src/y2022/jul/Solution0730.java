package y2022.jul;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-subsets/
public class Solution0730 {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        int[] checkMap = new int[26];
        for (String word : words2) {
            int[] map = wordMap(word);

            for (int i = 0; i < 26; i++) {
                checkMap[i] = Math.max(checkMap[i], map[i]);
            }

        }

        for (String word : words1) {
            boolean check = true;

            int[] wordMap = wordMap(word);

            for (int i = 0; i < 26; i++) {
                if (checkMap[i] > wordMap[i]) {
                    check = false;
                    break;
                }
            }

            if (check) {
                ans.add(word);
            }
        }


        return ans;
    }

    private int[] wordMap(String word) {
        int[] map = new int[26];

        for (int i = 0; i < word.length(); i++) {
            map[word.charAt(i) - 'a'] ++;
        }

        return map;

    }


    public List<String> wordSubsetsTimelimit(String[] words1, String[] words2) {
        /*
        모든 words2 이 포함된 words1의 값을 반환

        words2 -> map으로 반환
        해당 words2가 word1에 들어 있는지 확인
         */
        List<String> ans = new ArrayList<>();

        List<int[]> word2MapList = new ArrayList<>(words2.length);
        Set<String> set = new HashSet<>();
        for (String word : words2) {
            set.add(word);
        }
        for (String word : set) {
            word2MapList.add(wordMap(word));
        }

        for (String word : words1) {
            boolean check = true;

            int[] wordMap = wordMap(word);
            for (int[] map : word2MapList) {

                for (int i = 0; i < 26; i++) {
                    if (map[i] > wordMap[i]) {
                        check = false;
                        break;
                    }
                }
                if (!check) {
                    break;
                }
            }

            if (check) {
                ans.add(word);
            }
        }


        return ans;
    }



}
