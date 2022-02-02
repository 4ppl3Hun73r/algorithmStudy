package y2022.jun;

// https://leetcode.com/problems/richest-customer-wealth/
public class Solution0131 {
    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int[] account : accounts) {

            int sum = 0;
            for (int m : account) {
                sum += m;
            }
            max = Math.max(sum, max);
        }

        return max;

    }
}
