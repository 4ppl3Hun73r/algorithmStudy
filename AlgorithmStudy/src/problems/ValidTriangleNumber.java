package problems;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                for (int k = j + 1; k < len; k++) {
                    if (sum > nums[k]) {
                        result ++;
                    } else {
                        break;
                    }
                }
            }
        }

        return result;

    }
}
