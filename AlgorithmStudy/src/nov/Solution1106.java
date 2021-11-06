package nov;

import java.util.Arrays;

// https://leetcode.com/problems/single-number-iii/
public class Solution1106 {

    public int[] singleNumber(int[] nums) {
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t = t ^ nums[i];
        }

        //System.out.println(Integer.toBinaryString(t));
        //System.out.println(Integer.toBinaryString(-t));
        t &= -t;
        //System.out.println(Integer.toBinaryString(t));

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((t & nums[i]) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
            System.out.println(Arrays.toString(result));
        }

        /*
           1,2,1,3,2,5
           7,4,7,5,4,3


         */
        return result;
    }

    public static void main(String[] args) {
        Solution1106 s = new Solution1106();

        s.singleNumber(new int[]{1,2,1,3,2,5});
    }
}
