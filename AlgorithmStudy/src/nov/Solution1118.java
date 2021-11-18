package nov;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class Solution1118 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // swap?
        // nums 값이 양수다.
        /*
          [4,3,2,7,8,2,3,1]
          [-4,-3,-2,-7,8,2,-3,-1]
         */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // bb
            }
        }

        return result;
    }


    public List<Integer> findDisappearedNumbersCount(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num - 1]++;
        }

        // swap?
        // nums 값이 양수다.

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution1118 s = new Solution1118();

        System.out.println(s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1})); // 5, 6
    }
}
