package oct;


// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class Solution1023 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            int l = nums[left];
            int r = nums[right];
            mid = (left + right) / 2;
            int m = nums[mid];

            System.out.println("l : " + l + ", m : " + m + ", r : " + r);
            // 3,5,1
            if (r < m) { // 1 < 5
                left = mid + 1; // [1]
            } else if (m < r) { // 1,3,5, 3 < 5
                right = mid; // [1,3]
            } else { // m == r, 1,1,1, 0,1,1
                if (l == m) { // 1,1,1
                    left++;
                    right--;
                } else { // 0,1,1
                    right = mid;
                }
            }
        }

        return nums[right];
    }

    public static void main(String[] args) {
        Solution1023 s = new Solution1023();
        System.out.println(s.findMin(new int[]{1,3,5}));
        System.out.println(s.findMin(new int[]{1,2,2,2,0,1}));
        System.out.println(s.findMin(new int[]{2,2,2,0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2}));

    }

}
