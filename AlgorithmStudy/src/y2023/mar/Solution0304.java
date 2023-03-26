package y2023.mar;

// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
public class Solution0304 {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        /*
        minK
        maxK

        subarray 인데 min max 가 minK maxK 를 만족해야함
        subarray 이기 때문에 정렬 할 수 없음


        [ - - - - - - - - - - - ]
          i                   a  -> 1

         */

        long count = 0;

        int minIdx = -1;
        int maxIdx = -1;
        int reset = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < minK || num > maxK) {
                reset = i;
            }
            if (num == minK) {
                minIdx = i;
            }
            if (num == maxK) {
                maxIdx = i;
            }
            count += Math.max(0L, Math.min(minIdx, maxIdx) - reset);
        }

        return count;

    }
}
