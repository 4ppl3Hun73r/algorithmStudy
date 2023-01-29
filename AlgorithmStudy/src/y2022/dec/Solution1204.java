package y2022.dec;

// https://leetcode.com/problems/minimum-average-difference/
public class Solution1204 {
    public int minimumAverageDifference(int[] nums) {
        /*
        n 번째까지의 펼균과 그 이후의 평균의 차이의 절대값

        [a, b, c, d, e, f, g]

        [0, a, a + b, a + b + c, a + b + c + d, a + b + c + d + e, a + b + c + d + e + f, a + b + c + d + e + f + g]

        a, b + c + d + e + f + g
        a + b, c + d + e + f + g

         */

        long min = Long.MAX_VALUE;
        int minIdx = 0;

        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        long sum = prefixSum[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            long left = prefixSum[i - 1];
            long right = sum - left;
            long avgDiff = Math.abs((left / i) - (right / (nums.length - i)));
            if (avgDiff < min) {
                min = avgDiff;
                minIdx = i - 1;
            }
        }
        if ((sum / nums.length) < min) {
            minIdx = nums.length - 1;
        }

        return minIdx;
    }

    public static void main(String[] args) {
        Solution1204 s = new Solution1204();

        //System.out.println(s.minimumAverageDifference(new int[]{2,5,3,9,5,3}));

        System.out.println(s.minimumAverageDifference(new int[]{4,2,0}));
/*
        Random r = new Random();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            l.add(r.nextInt(10000));
        }
        System.out.println(l);*/
    }
}
