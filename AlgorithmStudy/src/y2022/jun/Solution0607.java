package y2022.jun;

// https://leetcode.com/problems/merge-sorted-array/
public class Solution0607 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        nums1 = [1,2,3,0,0,0], m = 3,
        nums2 = [2,5,6], n = 3
        ------
        nums1 = [1,2,2,3,5,6]

        lI = 3, 2, 2, 1
        lI = 6, 5, 2

        nums[1] = [1,2,3,0,0,0]
        nums[2] = [4,5,6]
         */

        int num1LastIndex = m - 1;
        int num2LastIndex = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (num2LastIndex < 0 ||
                    (num1LastIndex >= 0 && nums1[num1LastIndex] > nums2[num2LastIndex])) {
                nums1[i] = nums1[num1LastIndex];
                num1LastIndex--;
            } else {
                nums1[i] = nums2[num2LastIndex];
                num2LastIndex--;
            }
        }
    }
}
