package sep;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3958/
public class Solution0901 {

    public int findMin(int[] nums) {
        // [a0, a1, a2, a3, a4, a5] -> roll
        // find min O(logN)
        // 2 -> 1번
        // 4 -> 2
        // 6 -> 2번
        // 8 -> 3
        // 16 -> 4

        // arr[0] <-> arr[n-1]
        // min = arr[0], arr[n-1]
        // arr[0 + 2/n] <-> arr[n-]
        // [6,7,8,0,1,2,3,4,5]
        // [4,5,6,7,0,1,2] -> 1..
        // 4 , mid 3, 7




        // [0,1,2,3,4,5,6]
        // [1]

        // [4,5,6,7,0,1,4] < wrong
        // [10,1,10,10,10] < wrong

        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        int mid = 0;

        while (left < right) {
            int l = nums[left];
            int r = nums[right];
            mid = (left + right) / 2;

            if (min <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("left :" + left + ", right :" + right + ", mid : " + mid);
        }

        int idx = (left + 1) % nums.length;
        return nums[left] > nums[idx] ? nums[idx] : nums[left];

    }
    /*
        "[3,4,5,1,2]",
        "[4,5,1,2,3]",
        "[5,1,2,3,4]",
        "[1,2,3,4,5]",
        "[2,3,4,5,1]",
        "[1,2,3,4,5,6]",
        "[6,1,2,3,4,5]",
        "[5,6,1,2,3,4]",
        "[4,5,6,1,2,3]",
        "[3,4,5,6,1,2]",
        "[4,5,6,7,0,1,2]",
        "[11,13,15,17]",
        "[4,5,6,7,0,1,2]"
        fun findMin(nums: IntArray): Int {
            val index = find(nums, 0, nums.size - 1)
            val current = nums[index]
            val next = nums[(index + 1) % nums.size]
            return if (current < next) current else next
        }

        private fun find(nums: IntArray, start: Int, end: Int): Int {
            if (start >= end) return start
            val mid = (start + end) / 2
            return when {
                nums[0] <= nums[mid] -> find(nums, mid + 1, end)
                nums[0] > nums[mid] -> find(nums, start, mid - 1)
                else -> -1 // impossible input
            }
        }
     */

    public static void main(String[] args) {
        Solution0901 solution0901 = new Solution0901();
        System.out.println(solution0901.findMin(new int[]{4,5,6,7,0,1,2}));
    }
    public int jiho(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[left];

        while (left <= right) {
            int mid = (left + right) / 2;
            int l = nums[left];
            int r = nums[right];
            int m = nums[mid];

            // [6,7,8,0,1,2,3,4,5]
            // [4,5,6,7,0,1,2]

            if (l > m) {
                right = mid - 1;
            }
            if (l < m) {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
