package y2022.jun;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class Solution0611 {

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int l = 0;
        int r = 0;
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        while (l <= r) {
            if (sum >= x) {
                if (sum == x) {
                    res = Math.min(res, l + len - r);
                }
                if (r < len) {
                    sum -= nums[r++];
                } else {
                    break;
                }
            } else {
                sum += nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // 시간초과
    public int minOperationsTimeLimitExceeded(int[] nums, int x) {
        /*
        x -> 0 이 될 수 있는 최소한의 방법
        nums 의 가장 왼쪽, 가장 오른쪽에서 값을 가져와야함.

        0을 만들 방법이 없으면 -1 반환

        idea.
        prefix sum?
        [a, b, c, d, e, f, g]
        [a, a + b, a + b + c, a + b + c + d, a + b + c + d + e, a + b + c + d + e + f, a + b + c + d + e + f + g]

        x = a + b + f + g ?
         -> (a + b .. + g) - (a + b .. + e) + (a + b)
         -> p[6] - p[4] + p[1] -> 0 + 1 + 5 + 6
         -> p[6] -> 고정
            -> p[1] - p[4] = x - p[6] 가 되면 됨.

            0, 6
         */
        int len = nums.length;
        int[] leftPrefixSum = new int[len];
        int[] rightPrefixSum = new int[len];
        leftPrefixSum[0] = nums[0];
        rightPrefixSum[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            leftPrefixSum[i] = leftPrefixSum[i - 1] + nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightPrefixSum[i] = rightPrefixSum[i + 1] + nums[i];
        }

        int ans = findX(leftPrefixSum, rightPrefixSum, -1, len, x);

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }


    int findX(int[] leftPrefixSum, int[] rightPrefixSum, int leftPos, int rightPos, int x) {
        if (leftPos > rightPos || leftPos == leftPrefixSum.length || rightPos == -1) {
            return Integer.MAX_VALUE;
        }
        int left = 0;
        int right = 0;
        if (leftPos >= 0) {
            left = leftPrefixSum[leftPos];
        }
        if (rightPos != rightPrefixSum.length) {
            right = rightPrefixSum[rightPos];
        }


        int sum = left + right;
        if ( x == sum) {
            return 1 + leftPos + rightPrefixSum.length - rightPos;
        }
        if ( x < sum ) {
            return Integer.MAX_VALUE;
        }

        int l = findX(leftPrefixSum, rightPrefixSum, leftPos + 1, rightPos, x);
        int r = findX(leftPrefixSum, rightPrefixSum, leftPos, rightPos - 1, x);

        return Math.min(l, r);
    }

    public static void main(String[] args) {
        int[] nums = {1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136};
        Solution0611 s = new Solution0611();
        System.out.println(s.minOperations(nums, 894887480));
    }
}
