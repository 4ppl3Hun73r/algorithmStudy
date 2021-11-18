package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */
        Map<String, List<String>> map = new HashMap<>();
        // 쉬운 접근 -> sort -> grouping
        // hash table???
        // str => char map : []? -> a24b24c24 이렇게 바꾸기?
        // 100 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 4
        // 100 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 14
        int[] a = new int[26];

        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                a[c - 'a'] ++;
            }

            // Arrays.hashCode(a); -> 이런 방법도 있음
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (a[j] != 0) {
                    sb.append(j + 'a');
                    sb.append(a[j]);
                    a[j] = 0;
                }
            }
            String hash = sb.toString();
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(sb.toString()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
