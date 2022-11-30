package y2022.nov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/unique-number-of-occurrences/
public class Solution1130 {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer cnt : map.values()) {
            if (set.contains(cnt)) {
                return false;
            }
            set.add(cnt);
        }



        return true;

    }
}
