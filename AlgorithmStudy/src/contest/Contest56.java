package contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Contest56 {


    public long minimumDifference(int[] nums) {

        int len = nums.length;
        int n = len / 3;

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long[] leftSum = new long[len];
        long[] rightSum = new long[len];

        long sum = 0;
        for (int i = 0; i < n * 2; i++) {
            sum += nums[i];
            left.add(nums[i]);
            if (left.size() > n) {
                sum -= left.poll();
            }
            leftSum[i] = sum;
        }

        sum = 0;
        for (int i = len - 1; i >= n ; i--) {
            sum += nums[i];
            right.add(nums[i]);
            if (right.size() > n) {
                sum -= right.poll();
            }
            rightSum[i] = sum;
        }

        long res = Long.MAX_VALUE;
        for (int i = n - 1; i < n * 2; i++) {
            res = Math.min(res, leftSum[i] - rightSum[i + 1]);
        }

        return res;
    }


    /*
    좀 급하게 푸느냐고 접근도 별로 였음.. ㅠ
     */
    public long minimumDifferenceFail(int[] nums) {

        //
        //
        int n = nums.length / 3;

        // n 개의 엘리멘트를 제거 해야함
        Arrays.sort(nums, 0, n);
        Arrays.sort(nums, n, nums.length);

        int left = 1;
        int right = 0;

        for (int j = 0; j < n; j++) {
            if (nums[n - left] > nums[n + right]) {
                nums[n - left] = 0;
                left++;
            } else {
                nums[n + right] = 0;
                right++;
            }
        }

        long leftSum = 0;
        long rightSum = 0;

        n = (nums.length - n) / 2;
        int idx = 0;
        for (int i = 0; i < n; i++, idx++) {
            if (nums[idx] == 0) {
                i--;
                continue;
            }
            leftSum += nums[idx];
        }

        for (int i = 0; i < n; i++, idx++) {
            if (nums[idx] == 0) {
                i--;
                continue;
            }
            rightSum += nums[idx];
        }

        return leftSum - rightSum;
    }

    public static void main(String[] args) {
        Contest56 c = new Contest56();

        c.minimumDifference(new int[]{7,9,5,8,1,3});
    }
}
