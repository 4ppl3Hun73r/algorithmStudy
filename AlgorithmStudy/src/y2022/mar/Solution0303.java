package y2022.mar;

// https://leetcode.com/problems/arithmetic-slices/
public class Solution0303 {

    public int numberOfArithmeticSlices(int[] nums) {
        /*
        3개 이상으로 구성되어 있고 동일한 차이를 가지고 있을때 Arithmetic 라고 함
        [1,2,3,4]
          [1,2,3]
          [2,3,4]
          [1,2,3,4]

           [1,2,3,4,6,7,8,9]
         [1,2,3]   : 1
         [1,2,3,4] : 3 1 + 2
         [1,2,3,4,5] : 6 3 + 3
         [1,2,3,4,5,6] : 10 6 + 4
         */

        if (nums.length < 3) {
            return 0;
        }

        int ans = 0;

        int arithmeticCnt = 0;
        int countSubsequence = 0;
        int diff = nums[0] - nums[1];
        for (int i = 1; i < nums.length; i++) {
            int subDiff = nums[i - 1] - nums[i];
            if (subDiff != diff) {
                diff = subDiff;
                ans += arithmeticCnt;
                countSubsequence = 0;
                arithmeticCnt = 0;
            }
            countSubsequence++;
            if (countSubsequence >= 2) {
                arithmeticCnt += (countSubsequence - 1);
            }
        }
        ans += arithmeticCnt;

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0303 s = new Solution0303();
        System.out.println(s.numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(s.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6,7}));
        System.out.println(s.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6,7,10,1,2,3,4,5,6,7,20}));
    }
}
