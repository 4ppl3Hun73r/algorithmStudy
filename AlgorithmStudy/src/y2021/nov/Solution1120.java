package y2021.nov;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class Solution1120 {
    public int singleNonDuplicate(int[] nums) {
        // Your solution must run in O(log n) time and O(1) space.
        /*
        정렬 되어 있음
        같은 엘리먼트가 2번씩 나옴
        한 엘리먼트만 한번 나옴
         */

        /*
        [1,1,2,2,3,3,4,4,5,5,6,6,7,7]
        [1,1,2,2,3,3,4,4,5,5,6,6,7]
                     ^
                     짝수 i 랑 i + 1의 값이 같다면
                     같다면 right에 답이 있음
        [1,2,2,3,3,4,4,5,5,6,6,7,7]
                     ^ left에 답이 있음
         */
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            boolean even = mid%2 == 0;
            System.out.println(mid); // 짝수만 나와야 함
            System.out.println(nums[mid]);
            System.out.println(nums[mid + 1]);

            if (even) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution1120 s = new Solution1120();
        System.out.println("A : " + s.singleNonDuplicate(new int[]{1,2,2,3,3,4,4,5,5,6,6,7,7}));
        System.out.println("A : " + s.singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7}));
        System.out.println("A : " + s.singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5,6,6,7,7}));

    }
}
