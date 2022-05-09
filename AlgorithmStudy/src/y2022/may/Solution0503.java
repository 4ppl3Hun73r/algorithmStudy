package y2022.may;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class Solution0503 {

    public int findUnsortedSubarray(int[] nums) {
        /*
         정렬안된 부분을 찾는데, 가장 작은 부분의 길이

        //[2, 7, 6, 3, 5, 9]
//        [1, 3, 4, 8]

         [2,6,4,17,8,10,9,15]
              6    17 17 17 17
         [2,4,6,8,9,10,15,17]
            ^              ^


         [2,6,4,17,8,10,9,15]
         -> 큰 [0,0,6,0,17,17,17,17]
         -> 작 [0,4,0,0,0,9,0,0]


         Monotonic Stack
         */

        System.out.println(Arrays.toString(nums));
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i); //여기서
            System.out.println(stack +" l : "+l);
        }//O(2n) ->

        // stack 순회


        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
            System.out.println(stack + " r :  " + r);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        Solution0503 s = new Solution0503();

        System.out.println(s.findUnsortedSubarray(new int[]{2,6,4,17,8,10,9,15}));
    }

    public int findUnsortedSubarraySuccess(int[] nums) {
        /*
         정렬안된 부분을 찾는데, 가장 작은 부분의 길이

         [2,6,4,8,10,9,15]

         [2,4,6,8,9,10,15]
            ^        ^


         */

        int copyNum[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copyNum[i] = nums[i];
        }
        Arrays.sort(copyNum);

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyNum[i]) {
                start = i;
                break;
            }
        }

        int end = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != copyNum[i]) {
                end = i;
                break;
            }
        }
        if (end == start) {
            return 0;
        }

        return end - start + 1;
    }
}
