package y2022.feb;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class Solution0206 {
    public int removeDuplicates(int[] nums) {
        /*
        정렬된 nums 가 들어옴
        2개 이상이 있는 element는 제거함
        O(1) space 로 문제를 풀어야함 nums 재활용
        [0,0,1,1,1,1,2,3,3]
        [0,0,1,1,2,3,3,_,_]
         */
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 2; i < nums.length; i++) {
            int n = nums[i];
            if (nums[i - 2] == n) {
                for (; i < nums.length; i++) {
                    if (nums[i] != n) {
                        break;
                    }
                    nums[i] = 100001;
                }
                if (i == nums.length) {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

        int pivot = 0;
        for (int i = 0; i < nums.length; i++, pivot++) {
            int n = nums[i];
            if (n == 100001) {
                for (; i < nums.length; i++) {
                    if (nums[i] != 100001) {
                        break;
                    }
                }
                if (i == nums.length) {
                    break;
                }
            }
            nums[pivot] = nums[i];
        }

        System.out.println(Arrays.toString(nums));
        return pivot;
    }

    public static void main(String[] args) {
        Solution0206 s = new Solution0206();
        /*System.out.println(s.removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(s.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(s.removeDuplicates(new int[]{0,0,0,0,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3}));
        System.out.println(s.removeDuplicates(new int[]{-100,-100,-100,-100,0,0,0,0,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3}));*/


        /*System.out.println(s.removeDuplicates(new int[]{0,0,0}));
        System.out.println(s.removeDuplicates(new int[]{0,0}));
        System.out.println(s.removeDuplicates(new int[]{0}));*/

        System.out.println(s.removeDuplicates(new int[]{1,1,1,2,2,2,3,3,3,3}));
    }

}
