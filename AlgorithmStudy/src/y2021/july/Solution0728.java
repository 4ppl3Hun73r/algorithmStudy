package y2021.july;

import java.util.Arrays;

// https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3828/
public class Solution0728 {
    public static int threeSumClosest(int[] nums, int target) {
        int closestTarget = 0;

        // [-1,2,1,-4], target = 1
        // O(n3) -> 줄이는 방법?
        // O(nlogn) + O(n3) => o(n3)
        // O(nlogn) + O(nlogn) / O(n2) => O(n2)
        Arrays.sort(nums);

        // [-4, -1, 1, 2], 1
        // [a,  b,     c], 1 > -3 : diff : 4
        // [a,   ,  b, c], 1 > -1 : diff : 2
        // [ ,  a,  b, c], 1 < 2 : diff : 1 정답 "2";
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ib = i + 1;
            int ic = nums.length - 1;
            while (ib < ic) {
                int sum = nums[i] + nums[ib] + nums[ic];
                int sDiff = Math.abs(target - sum);
                if (sDiff < diff) {
                    diff = sDiff;
                    result = sum;
                }
                if (sDiff == 0) {
                    return sum;
                }
                if (target > sum) {
                    ib++;
                } else {
                    ic--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-5, 2, 1, 3, 7, 20 ,-1}, 4));
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));

    }
}

/*
[-5, 2, 1, 3, 7, 20 ,-1], 4
[-5, -1, 1, 2, 3, 7, 20]
  a  b                c : 4 < 14
  a  b            c     : 4 < 6
  a  b         c        : 4 > -3
  a      b     c        : 4 > -1
  a         b  c        : 4 > 0
     a      b  c        : 4 = 4
 */