package problems;

import java.util.Arrays;

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int idx = 0;
        int prev = nums[0];
        int idx2 = 1;
        int prev2 = nums[1];
        for (int i = 0; i < len / 2; i++) {
            int newIndex = (idx + k) % len;
            int temp = nums[newIndex];
            nums[newIndex] = prev;
            prev = temp;
            idx = newIndex;

            int newIndex2 = (idx2 + k) % len;
            int temp2 = nums[newIndex2];
            nums[newIndex2] = prev2;
            prev2 = temp2;
            idx2 = newIndex2;

            System.out.println(Arrays.toString(nums));
        }
        // TODO how to check cyclic-dependencies????
        //nums[(idx + k) % len] = prev;
    }
    // [1,2,3,4,5,6,7]
    // [5,6,7,1,2,3,4]
    //
    /*
    k = 3
      [0,1,2,3,4,5,6,7]
      [5,6,7,0,1,2,3,4]

      [7,6,5,4,3,2,1,0]
      [5,6,7,4,3,2,1,0]
      [5,6,7,0,1,2,3,4]
     */

    // https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
    public void reverse3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();

        r.rotate(new int[]{-1,-100,3,99}, 2);

    }

}
