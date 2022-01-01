package y2021.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0918 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] numLong = nums1;
        int[] numShort = nums2;
        if (len1 < len2) {
            numLong = nums2;
            numShort = nums1;
        }

        // map 만들기
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : numLong) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : numShort) {
            int cnt = numCountMap.getOrDefault(num, 0);
            if (cnt != 0) {
                result.add(num);
                numCountMap.put(num, cnt - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
