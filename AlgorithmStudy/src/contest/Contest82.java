package contest;

import java.util.Arrays;

public class Contest82 {

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        long ans = 0;
        int diffSum = 0;
        for (int i = 0; i < nums.length && k > 0; i++) {
            long prevNum = i == 0 ? 0 : nums[i - 1];
            long cnt = Math.min((long) k, Math.max(0L, nums[i] - prevNum - 1));
            k -= cnt;

            ans += (prevNum + 1 + prevNum + cnt) * cnt / 2;
        }

        if (k > 0) {
            long num = nums[nums.length - 1];
            ans += (long)((num + 1 + num + k) * k / 2);
        }

        return ans;
    }

    /*
    접근은 맞았는데...
    k 를 계산하는 공식이 잘 안 되었음
     */
   public long minimalKSumFail(int[] nums, int k) {
        /*
        nums 에 k 번 만큼 더해서 최소로 만들기

        k는 1부터 시작

        가장 작다 == nums.length + k 값이 나와야함.

        즉 앞에서 부터 k 로채우고 nums 는 k번이 넘어 갔을때 채우면 된다.
         */

        Arrays.sort(nums);

        long ans = 0;
        int diffSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            int right = 0;
            if (i == 0) {
                right = 1;
            } else {
                right = nums[i - 1];
            }

            diffSum = left - right;
            if (k != 0 && diffSum != 0) {
                k = k - diffSum;
                int a = left;
                int b = right - 1;
                ans += (a * (a + 1)) / 2 - (b * (b + 1) / 2);
            }
        }

        if (k != 0) {
            int b = nums[nums.length - 1];
            int a = b + k;
            ans += (a * (a + 1)) / 2 - (b * (b + 1) / 2);
        }

        return ans;
    }

    public static void main(String[] args) {
        Contest82 c = new Contest82();

        //c.minimalKSum(new int[]{1,2,3}, 6);
        //c.minimalKSum(new int[]{1,2,3,4}, 6);
        //c.minimalKSum(new int[]{1,2,3,4,10}, 7);
        System.out.println(c.minimalKSum(new int[]{5,6}, 6));
    }
}
