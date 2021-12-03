package dec;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-subarray/
public class Solution1203 {
    public int maxProduct(int[] nums) {

        /*
            -> (-) X (-)
            [-2,3,-4]
            dp[0] = -2
            dp[1] = -2 * 3 VS 3
            dp[2] = 3 vs -12 vs (-2*3*-4) <-- how?
            => output:  3
            => expected : 24

            dp[0] = -2
            dp[1] = -2 * 3 vs 3 = -6, 3
            dp[2] = -6 * -4 vs -4 vs 3 * -4 = 24 vs -4 vs -12


       */

        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int max = maxDp[0];
        for (int i = 1; i < nums.length; i++) {
            /*
            nums  -2, 3, -4
             dp1  -2   3   24
             dp2  -2  -6  -12
             */
            if(nums[i] >= 0) {
                maxDp[i] = Math.max(maxDp[i - 1] * nums[i], nums[i]);
                minDp[i] = Math.min(minDp[i - 1] * nums[i], nums[i]);
            } else {
                maxDp[i] = Math.max(minDp[i - 1] * nums[i], nums[i]);
                minDp[i] = Math.min(maxDp[i - 1] * nums[i], nums[i]);
            }
            max = Math.max(maxDp[i], max);
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(maxDp));
        System.out.println(Arrays.toString(minDp));

        return max;
    }

    // https://leetcode.com/problems/maximum-product-subarray/discuss/183483/JavaC%2B%2BPython-it-can-be-more-simple
    // https://medium.com/@vdongbin/kadanes-algorithm-%EC%B9%B4%EB%8D%B0%EC%9D%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-acbc8c279f29
    public int maxProduct2(int[] A) {
        int n = A.length;
        int res = A[0];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * A[i];
            r =  (r == 0 ? 1 : r) * A[n - 1 - i];
            System.out.printf("l : %d, r : %d, A[i]: %d %d, A[n - 1 - i]: %d %d\n",
                    l, r, A[i], i, A[n - 1 - i], n - 1 - i);

            res = Math.max(res, Math.max(l, r));

            /*
            -2, 3, -4
            l       r  (0,0), (2,2)
                lr     (0,1), (1,2)
            r       l  (0,2), (0,2)

            2,3,-2,4
            l      r  (0,0), (3,3)
              l  r    (0,1), (2,3)
              r  l    (0,2), (1,3)
            r      l  (0,4), (0,4)

            (0 ~ 0), (0 ~ 1), (0 ~ 2)
            (1 ~ 1), (1 ~ 2), (2 ~ 2)
             */
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Solution1203 s = new Solution1203();

        System.out.println(s.maxProduct2(new int[]{2,3,-2,4}));
        System.out.println(s.maxProduct2(new int[]{-2,3,-4})); // 24
        System.out.println(s.maxProduct2(new int[]{-2,1,-1})); // 24
    }
}
