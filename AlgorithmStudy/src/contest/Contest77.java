package contest;

import java.util.HashMap;
import java.util.Map;

public class Contest77 {


    public int mostFrequent(int[] nums, int key) {

        Map<Integer, Integer> frequentMap = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                frequentMap.put(nums[i + 1], frequentMap.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        int mostFrequentTarget = 0;
        int frequent = 0;
        for (Map.Entry<Integer, Integer> targetCount : frequentMap.entrySet()) {
            if (targetCount.getValue() > frequent) {
                frequent = targetCount.getValue();
                mostFrequentTarget = targetCount.getKey();
            }
        }

        return mostFrequentTarget;
    }

    public static void main(String[] args) {
        Contest77 c = new Contest77();

    }
}
