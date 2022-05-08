package y2022.may;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/
public class Solution0507 {
    public boolean find132pattern(int[] nums) {
        /*
        nums[i], nums[j] and nums[k] such that
        i < j < k
        nums[i] < nums[k] < nums[j].
        nums[j] > nums[k]
        num
         */

        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while(!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution0507 s = new Solution0507();

        //System.out.println(s.find132pattern(new int[]{1,2,3,4}));
        System.out.println(s.find132pattern(new int[]{5,3,1,4,2}));
        System.out.println(s.find132pattern(new int[]{1,0,1,-4,-3}));


    }
}
