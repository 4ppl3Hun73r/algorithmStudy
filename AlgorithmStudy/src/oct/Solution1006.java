package oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class Solution1006 {
    public List<Integer> findDuplicates(int[] nums) {
        // nums[i] = 1 ~ n
        // n = nums.length;
        // Array, hash table
        // you must O(n), constant extra space

        List<Integer> result = new ArrayList<>();

        // 4,3,2,7,8,2,3,1
        //   2 3 4     7   -> result.add(3);
        // 1 2           8 -> result.add(2);

        /*
            4,3,2,7,8,2,3,1
            7,3,2,4,8,2,3,1
            3,3,2,4,8,2,7,1
            2,3,3,4,8,2,7,1
            3,2,3,4,8,2,7,1
              ㄴ
            4,3,2,7,8,2,3,1
         */

        /*
            3,3,4,4,5,5,6,6
            4,3,3,          -> result add 3
                  4

         */

        /*
            4,3,2,7,8,2,3,1
            7,3,2,4,8,2,3,1
            3,3,2,4,8,2,7,1
            2,3,3,4,8,2,7,1
            3,2,3,4,8,2,7,1
                    ^
            3,2,3,4,1,2,7,8
            1,2,3,4,3,2,7,8
                          ^
            7,3,2,4,8,2,3,1
            3,3,2,4,8,2,7,1
            2,3,3,4,8,2,7,1
            3,2,3,4,8,2,7,1
            3,2,3,4,8,2,7,1
            3,2,3,4,1,2,7,8
            1,2,3,4,3,2,7,8  ----> 3, 2

            3,3,4,4,5,5,6,6
            4,3,3,4,5,5,6,6
            4,3,3,4,5,5,6,6  ----> 4, 3, 5, 6
         */
        int index = 0;
        // loop 13번
        while (index < nums.length) {
            System.out.println(Arrays.toString(nums));
            // 값 1이 0자리 값 8이 7자리
            int index2 = nums[index] - 1; // 자기 자리
            // nums[index] == nums[index2] => // 자기가 갈자리에 이미 맞는 값이 있는 경우

            if ( nums[index] != index + 1 // 자기 자리에 없거나
                    && nums[index] != nums[index2] // 지가 갈 자리에 이미 맞는 값이 있거나
                ) {
                int temp = nums[index];
                nums[index] = nums[index2];
                nums[index2] = temp;
            } else {
                index++;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                result.add(nums[i]);
            }
        }

        return result;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index]; // 음수로 바꿔줌
        }

        /*
           4,3,2,7,8,2,3,1
           4,3,2,-7,8,2,3,1
           4,3,-2,-7,8,2,3,1
           4,-3,-2,-7,8,2,3,1
           4,-3,-2,-7,8,2,-3,1
           4,-3,-2,-7,8,2,-3,-1
           4,-3,-2,-7,8,2,-3,-1 -> result add
           4,3,-2,-7,8,2,-3,-1 -> result add
           -4,3,2,-7,8,2,-3,-1

           trick
         */

        return res;
    }

    public static void main(String[] args) throws Exception {
        Solution1006 s = new Solution1006();
        System.out.println(s.findDuplicates(new int[]{4,3,2,7,8,2,3,1})); // 2, 3
    }
}
