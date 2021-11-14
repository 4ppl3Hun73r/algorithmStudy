package problems;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
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

/*
[1,2,3,4]
prefix product =
[1, 2, 6, 24]
 a, a * b, a * b * c, a * b * c * d ?? not division?

[a, b, c, d]
[1, a, a * b, a * b * c] => prefix product
[b * c * d, c * d, d, 1] => prefix product reverse
pp * ppr
[1 * b * c * d, a * c * d, a * b * d, a * b* c]


[1, 3, 6, 10]
[a, a + b, a + b + c, a + b + c + d]
 (a + b + c) * d
 (b + c + d) * a = a * b + a * c + a * d

 a * (b + c + d) = a * b + a * c + a * d
 (a * c) * b = a * b * c

 b * c * d
 a * c * d
 a * b * d
 a * b * c
*/