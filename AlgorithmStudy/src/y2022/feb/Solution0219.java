package y2022.feb;

import java.util.PriorityQueue;
import java.util.TreeSet;

// https://leetcode.com/problems/minimize-deviation-in-array/
public class Solution0219 {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums)
            if (num % 2 == 0) {
                set.add(num);
            } else {
                set.add(num * 2);   // 각 수가 가질수 있는 최대 치로 설정해 놓는다.
            }

        int ans = Integer.MAX_VALUE;
        while (true) {
            int val = set.last();
            // 가장 큰 편차를 구한다.
            ans = Math.min(ans, val - set.first());
            if (val%2 == 0) {
                set.remove(val);
                set.add(val/2);
            } else {
                // 가장 큰 수가 홀수 이면 더이상 편차가 줄어들수 없는 상태로 볼 수 있다.
                break;
            }
        }
        return ans;

    }


    public int minimumDeviationFail(int[] nums) {
        /*
        홀수 -> 곱하기 2
        짝수 -> 나누기 2

        최소 편차는?

        홀수 -> 1,3,5,7 -> 2를 곱하면 짝수가 된다.
        짝수 -> 2,4,8,10 -> 2를 나누면 짝수 or 홀수가 된다.

        1 <= nums[i] <= 1000000000

        -> 모든 조합을 가진 set을 만들어서 편차를 구한다?

        -> nums[i] = 2^n * n ( n = 소수)
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        TreeSet<Integer>[] sets = new TreeSet[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sets[i] = new TreeSet<>();
            int num = nums[i];
            boolean even = num % 2 == 0;
            sets[i].add(num);
            if (even) {
                while (num % 2 == 0) {
                    num = num / 2;
                    sets[i].add(num);
                }
            } else {
                num = num * 2;
                if (num <= 1000000000) {
                    sets[i].add(num);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.max(min, sets[i].first());
            max = Math.min(max, sets[i].last());
        }
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }

        int deviation = max - min;
        for (int i = 0; i < nums.length; i++) {
            TreeSet<Integer> set = sets[i];
            if (set.contains(min) || set.contains(max)) {
                continue;
            }
            for (Integer n : set) {
                if (n > max) {
                    min = max;
                    max = n;
                } else if (n > min) {
                    if (n - min < max - n) {
                        max = n;
                    } else {
                        min = n;
                    }
                }
            }
        }

        return max - min;
    }
}
