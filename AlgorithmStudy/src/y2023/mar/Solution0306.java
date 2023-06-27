package y2023.mar;

// https://leetcode.com/problems/kth-missing-positive-number/
public class Solution0306 {
    public int findKthPositive(int[] arr, int k) {
        /*
        k 번째 없는 수를 찾아라.
         */

        int arrIdx = 0;
        int i = 1;
        for (i = 1; i <= 1000 && arrIdx < arr.length; i++) {
            if (arr[arrIdx] != i) {
                k--;
            } else {
                arrIdx++;
            }
            if (k == 0) {
                return i;
            }
        }

        return i + k - 1;
    }
}
