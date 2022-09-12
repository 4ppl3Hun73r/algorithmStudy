package y2022.sep;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-performance-of-a-team/
public class Solution0911 {


    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        /*
        최대 n 명

        그중 k 명을 뽑을 때

        max (speed  + speed ) * min(efficiency0, efficiency1) 를 구하라

        greed sorting pq
         */
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);


        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int[] se = arr[i];
            int speedI = se[0];
            int efficiencyI = se[1];

            pq.add(speedI);
            sum = (sum + speedI);
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            ans = Math.max(ans, (sum * efficiencyI));
        }
        long mod = 1000000007;
        return (int) (ans % mod);

    }

    public static void main(String[] args) {
        Solution0911 s = new Solution0911();

        System.out.println(s.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 2));
    }


}
