package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest47 {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int cnt = numCountMap.get(num);
            if (cnt == 1) {
                int plusOne = num + 1;
                int minusOne = num - 1;

                if (numCountMap.containsKey(plusOne) == false &&
                    numCountMap.containsKey(minusOne) == false) {
                    result.add(num);
                }
            }
        }



        return result;
    }

    public static void main(String[] args) {
        Contest47 c = new Contest47();

    }
}
