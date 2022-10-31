package y2022.oct;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class Solution1028 {

    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        ["aaaaaab","ab"]
        [["ab"],["aaaaaab"]]
         */
        // int[] alphabet = new int[26]; ++;
        // sort

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
