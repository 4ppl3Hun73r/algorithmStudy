package problems;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);
        int ans = 0;

        for (int left : capacity) {
            additionalRocks -= left;

            if (additionalRocks < 0) {
                break;
            }
            ans++;
        }


        return ans;

    }
}
