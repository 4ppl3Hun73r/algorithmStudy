package y2023.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-subsequence-score/
public class Solution0524 {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        /*
        nums1 에서 k개 뽑아 더하기

        Nums2 에서 동일한 위치의 k 개의 min 값 곱하기

        가장 큰 값은?
         */

        int n = nums1.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i][0];
            pq.offer(nums[i][0]);
        }

        long maxScore = sum * nums[k - 1][1];

        for (int i = k; i < n; i++) {
            sum += nums[i][0] - pq.poll();
            pq.offer(nums[i][0]);

            maxScore = Math.max(maxScore, sum * nums[i][1]);
        }

        return maxScore;
    }

    public static void main(String[] args) throws Exception {
        Solution0524 s = new Solution0524();

        System.out.println(s.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }
}
