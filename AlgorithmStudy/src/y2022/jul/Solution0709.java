package y2022.jul;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/jump-game-vi/
public class Solution0709 {



    public int maxResult(int[] nums, int k) {
        /*
        i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

       한칸 앞엑서 부터 (마지막 or i + k) 중에 점프 가능
        */

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        pq.offer(new int[]{nums[0], 0});

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < i - k ) {
                pq.poll();
            }

            max = nums[i] + pq.peek()[0];
            pq.offer(new int[]{max, i});
        }

        return max;


    }

    public int maxResult시간초과(int[] nums, int k) {
        /*
        i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

       한칸 앞엑서 부터 (마지막 or i + k) 중에 점프 가능
        */

        int[] cache = new int[nums.length];
        Arrays.fill(cache, Integer.MIN_VALUE);

        return dfs(nums, k, cache, 0);
    }


    // 시간 초과
    private int dfs(int[] nums, int k, int[] cache, int idx) {
        if (idx >= nums.length) {
            return 0;
        }
        if (idx == nums.length - 1) {
            return nums[idx];
        }
        if (cache[idx] > Integer.MIN_VALUE) {
            return cache[idx];
        }

        for (int i = idx + 1; i < nums.length && i <= idx + k; i++) {
            cache[idx] = Math.max(cache[idx], dfs(nums, k, cache, i));
            if (nums[i] > 0) {
                break;
            }
        }

        cache[idx] += nums[idx];

        return cache[idx];

    }
}
