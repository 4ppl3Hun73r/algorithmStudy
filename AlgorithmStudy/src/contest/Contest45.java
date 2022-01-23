package contest;

import java.util.Arrays;

public class Contest45 {
    public int countElements(int[] nums) {
        /*
        1,1,1,1
        1,1,10,10
        1
         */

        Arrays.sort(nums);
        int i = 1;
        for ( ;  i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                break;
            }
        }
        int j = nums.length - 1;
        for (; j > i; j--) {
            if (nums[j] != nums[j - 1]) {
                break;
            }
        }
        if ( j < i ) {
            return 0;
        }

        return j - i;
    }

    public static void main(String[] args) {
        Contest45 c = new Contest45();

        System.out.println(c.countElements(new int[]{1}));
        System.out.println(c.countElements(new int[]{1,1,1,1}));
        System.out.println(c.countElements(new int[]{10,10,10,10}));
        System.out.println(c.countElements(new int[]{1,1,10,10}));
        System.out.println(c.countElements(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
        System.out.println(c.countElements(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,15,15,15,15}));
        System.out.println(c.countElements(new int[]{1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,15,15,15,15}));

    }
}
