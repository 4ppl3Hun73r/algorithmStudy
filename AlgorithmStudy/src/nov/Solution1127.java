package nov;

// https://leetcode.com/problems/product-of-array-except-self/
public class Solution1127 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixProduct = new int[len];
        int[] prefixProductReverse = new int[len];

        prefixProduct[0] = 1;
        prefixProductReverse[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            prefixProductReverse[i] = prefixProductReverse[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = prefixProduct[i] * prefixProductReverse[i];
        }

        return nums;
    }
}
