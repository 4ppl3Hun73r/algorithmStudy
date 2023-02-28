package y2023.feb;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class Solution0221 {
    public int singleNonDuplicate(int[] nums) {
        /*
          다른 값들은 두번씩 나옴, 딱 하나만 나오는 값을 찾으시오.
          단 O(log n)의 속도와 O(1) 의 공간을 사용해야 함.

          [1,1,2,2,3,3,4,4,5,5,6,6]

           0 1 2 3 4 5 6 7 8 9 0 1 2
          [1,1,2,2,3,3,4,4,5,5,6,6,7]
                       ^
           0 1 2 3 4 5 6 7 8 9 0 1 2
          [0,1,1,2,2,3,3,4,4,5,5,6,6] //
                       ^


           [1,1,2,3,3,4,4,8,8]
           [3,3,7,7,10,11,11]

         */

        int left = 0;
        int right = nums.length - 1;

        // 0 , 8, 4
        //
        while(left < right) {
            int mid = left + (right - left) / 2;
            //System.out.println(left);
            //System.out.println(right);
            //System.out.println(mid);

            //if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid]) {
            //    return nums[mid];
            //}

            int delta = mid % 2 == 0 ? 1 : -1; // left == -1, right == 1
            if (nums[mid + delta] == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) throws Exception {
        Solution0221 s = new Solution0221();

        System.out.println(s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
