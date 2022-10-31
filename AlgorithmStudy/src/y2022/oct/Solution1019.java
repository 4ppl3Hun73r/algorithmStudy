package y2022.oct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/top-k-frequent-words/
public class Solution1019 {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordFrequentMap = new HashMap<>();
        for (String word : words) {
            wordFrequentMap.put(word, wordFrequentMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(wordFrequentMap);

        Set<Map.Entry<String, Integer>> entrySet = wordFrequentMap.entrySet();

        return entrySet.stream().sorted((a, b) -> {
            int countA = a.getValue();
            int countB = b.getValue();

            if (countA != countB) {
                return countB - countA;
            }

            return a.getKey().compareTo(b.getKey());

        }).map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        Solution1019 s = new Solution1019();

        System.out.println(s.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
    }
}
