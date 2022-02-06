package contest;

import java.util.Arrays;

public class Contest53 {

    public int minimumSum(int num) {

        // 1000 <= num <= 9999

        char[] nums = Integer.toString(num).toCharArray();
        Arrays.sort(nums);
        // 0129 -> 1 + 24, 12 + 9, 19, + 2

        int idx = 0;
        for (; idx < nums.length; idx++) {
            if (nums[idx] != '0') {
                break;
            }
        }

        if (idx == 0) {
            // 2933 -> 2339 -> 29 + 33 = 62, 23 + 39 => 62
            // 1223 ->
            return Integer.parseInt("" + nums[0] + nums[3], 10) + Integer.parseInt("" + nums[1] + nums[2], 10);
        }
        if (idx == 1) {
            return Integer.parseInt("" + nums[1] + nums[3], 10) + Integer.parseInt("" + nums[2], 10);
        }
        if (idx == 2) {
            return Integer.parseInt("" + nums[2], 10) + Integer.parseInt("" + nums[3], 10);
        }

        // 9988 -> 88 + 99
        // 9999

        return 0;
    }

    public static void main(String[] args) {
        Contest53 c = new Contest53();

    }
}
