package problems;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> numCntMap = new HashMap<>();

        for(int num : nums) {
            numCntMap.put(num, numCntMap.getOrDefault(num, 0) + 1);
        }

        for (Integer key : numCntMap.keySet()) {
            if (numCntMap.get(key) % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
