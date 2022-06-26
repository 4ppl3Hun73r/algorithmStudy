package y2022.jun;

// https://leetcode.com/problems/non-decreasing-array/
public class Solution0625 {
    public boolean checkPossibility(int[] nums) {
        /*
            배열에서 하나의 수만 바꿔서 non-decreasing 하는 배열로 만들 수 있는지 확인

            non-decreasing : nums[i] <= nums[i + 1]
         */

        boolean check = false;
        for (int i = 1; i < nums.length; i++) {
            int l = nums[i - 1];
            int r = nums[i];

            if (l > r) {
                if (check) {
                    return false;
                }
                check = true;

                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i]; // lower a[i - 1]
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }


        return true;
    }
}
