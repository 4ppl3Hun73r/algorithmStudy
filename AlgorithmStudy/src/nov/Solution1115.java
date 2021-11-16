package nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/
public class Solution1115 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        /*
        DP
             1  2  3  4  5  6  7  8  9  10
      count  1  1  1  1  1  1  1  1  1   1  - 자기 자신
      count  1  2  2  2  2  2  2  2  2   2  - 1로 나눠지니까   count[j] = max(count[j], count[i] + 1)
      count  1  2  2  3  2  3  2  3  2   3  - 2로 나눠지는거 + 1
      count  1  2  2  3  2  3  2  3  3   3  - 3으로 나눠지는거 + 1,
      count  1  2  2  3  2  3  2  4  3   3  - 4로 나눠지는거
      count  1  2  2  3  2  3  2  4  3   3  - 5로 나눠지는거
      count ...
      count  1  2  2  3  2  3  2  4  3   3 -> 8이 골라짐 -> 1, 2, 4, 8 ???
     preIdx -1  0  0  1  0  1  0  3  2   1    목록을 고를수 있겠다.
     preIdx  1  3  0  7  0  1  0  -1  2   1    목록을 고를수 있겠다.

         1 2 3 4 5 6 7 8  // count[j] = max(count[j], count[i] + 1)
     c   1 1   1       0
     n   7 7(3)7       -1
     c   1 1 1 1   0 0 0
     n   7 7(3)7       -1
     c   2 2 1 1 0 0 0 0
     n   3 3   7       -1
     c   3 2 1 1 0 0 0 0
     n   1 3   7       -1  // 1, 2, 4, 8 bbb

         4 8 10 240
     c   1 1  1  0
     n   3 3  3  -1
     c   1 1  1  0
     n   3 3  3  -1
     c   2 1  1  0
     n   1 3  3  -1
     idx = 0 -> 1 -> 3
           4    8    240
         */
        Arrays.sort(nums); // -> n*nlogn -> O(N^2)
        int[] count = new int[nums.length];
        int[] nextIdx = new int[nums.length];

        Arrays.fill(nextIdx, -1);
        int max = 0;
        int idx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] < count[i] + 1) { //
                        count[j] = count[i] + 1; // < update
                        nextIdx[j] = i;
                    }
                }
            }
            if (max < count[i]) {
                max = count[i];
                idx = i; // save index
            }
        }

        /*System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(nextIdx));*/

        while (idx != -1) {
            result.add(nums[idx]);
            idx = nextIdx[idx];
        }

        return result;
    }

    public List<Integer> me(int[] nums) {
        // 4   8         10       240
        // [4] [4,8,240] [10,240] [4,8,240]
        List<Integer>[] resultArr = new ArrayList[nums.length];
        int maxIndex = 0;
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            List<Integer> result = new ArrayList<>();
            resultArr[i] = result;
            if (num == 1) {
                result.add(num);
                continue;
            }

            for (int j=0; j<nums.length; j++) {
                int num2 = nums[j];
                if (num2 % num == 0 || num % num2 == 0) {
                    result.add(num2);
                }
            }

            if (resultArr[maxIndex].size() < result.size()) {
                maxIndex = i;
            }
        }


        return resultArr[maxIndex];
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);

        int max = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = countDiv(i, nums.length, nums[i], nums, 0, count, i, pre);
            count[i] = Math.max(m, count[i]);
            if (count[i] > max) {
                idx = i;
                max = count[i];
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(pre));

        while (idx != -1) {
            result.add(nums[idx]);
            if (idx == pre[idx]) {
                break;
            }
            idx = pre[idx];
        }

        return result;
    }

    private int countDiv(int start, int end, int num, int[] nums, int cnt, int[] count, int n, int[] next) {
        int max = cnt;
        for (int i = start; i < end; i++) {
            if (nums[i] % num == 0) {
                int c = countDiv(i + 1, end, nums[i], nums, cnt + 1, count, i, next);
                if (c > count[i]) {
                    next[n] = i;
                    count[i] = c;
                    max = c;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) throws Exception {
        Solution1115 s = new Solution1115();
        System.out.println(s.largestDivisibleSubset(new int[]{4,8,10,240}));
        System.out.println(s.largestDivisibleSubset(new int[]{8,10,240,4}));
        System.out.println(s.largestDivisibleSubset(new int[]{3, 17}));
        System.out.println(s.largestDivisibleSubset(new int[]{5,7,15,21,30,42}));
        System.out.println(s.largestDivisibleSubset(new int[]{10,11,12,13,14,15,16,17,18,19,20,30,40,50}));
        System.out.println(s.largestDivisibleSubset(new int[]{1 , 2 , 3 , 4 , 5 , 6 , 7  ,8 , 9  ,10}));
    }
}
