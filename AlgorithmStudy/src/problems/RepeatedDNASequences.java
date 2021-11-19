package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String key = s.substring(i, i + 10);
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() > 1) {
                result.add(stringIntegerEntry.getKey());
            }
        }

        return result;
    }
}
