package problems;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for(int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        return numCountMap.entrySet()
                .stream().sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();

        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
