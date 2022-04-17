package problems;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 0;
        int high = position[position.length - 1];

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 1;
            int last = position[0];
            for (int i = 0; i < position.length; i++) {
                if (position[i] - last >= mid) {
                    last = position[i];
                    count++;
                }
            }

            if (count >= m) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
