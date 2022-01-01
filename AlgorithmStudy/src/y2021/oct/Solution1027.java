package y2021.oct;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/
public class Solution1027 {
    public void sortColors(int[] nums) {
        // 1 <= n <= 300
        // 0, 1, 2 로만 이뤄진 배열을 정렬하시오.
        // Arrays.sort(nums);

        // Follow up: Could you come up with a one-pass algorithm using only constant extra space?
        // Array, Two point, Sort

        // [2,0,2,1,1,0]
        //  0,0,2,1,1,2 // bluePos --;
        //  0,0,2,1,1,2 // zeroPos++;
        //      1,1,2,2
        //
        // [1,0,1,1,2,2]

        // [2,0,2,1,1,0,1,1,0,1]
        // [1,0,2,1,1,0,1,1,0,2] // bluePos --;
        // [0,0,2,1,1,0,1,1,1,2] // redPos ++;
        // [0,0,2,1,1,0,1,1,1,2] // redPos ++;
        // [0,0,1,1,1,0,1,1,2,2] // bluePos --;
        // [0,0,0,1,1,1,1,1,2,2] // redPos ++;

        // [0,0,0,1,1,1,1,1,2,2]
        //                    i
        //        r       b

        int redPos = 0;  // 증가하는애
        // int whitePos = nums.length / 2; // --? ++?
        int bluePos = nums.length - 1; // 감소하는애
        for (int i = 0; i <= bluePos; i++) {
            int num = nums[i];
            if (num == 0) {
                swap(nums, i, redPos);
                redPos++;
            } else if (num == 2) {
                swap(nums, i, bluePos);
                bluePos--;
                i--; // b
            }
        }
        Arrays.sort(nums); // nlogn , n

        // System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        Solution1027 s = new Solution1027();

        s.sortColors(new int[]{0});
        s.sortColors(new int[]{2,1,2});
        s.sortColors(new int[]{2,0,2,1,1,0});
        s.sortColors(new int[]{2,2,2,2,2,2});
        s.sortColors(new int[]{2,2,2,2,2,1});
        s.sortColors(new int[]{1});
        s.sortColors(new int[]{2});
        s.sortColors(new int[]{1,0,1});
        s.sortColors(new int[]{2,0,2});
        s.sortColors(new int[]{2,0,2,1,1,0,1,1,0,1});
    }
}
