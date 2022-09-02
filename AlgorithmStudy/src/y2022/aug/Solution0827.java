package y2022.aug;

import model.GridCodec;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution0827 {

    // https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/1313721/JavaPython-Sub-problem%3A-Max-Sum-of-Subarray-No-Larger-Than-K-Clean-and-Concise
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int[] subSum = new int[col];
            for (int j = i; j < row; j++) {
                for (int c = 0; c < col; c++) {
                    subSum[c] += matrix[j][c];
                }
                System.out.println("subSum : " + Arrays.toString(subSum));
                ans = Math.max(ans, maxSumSubArray(subSum, col, k));
            }
        }

        return ans;
    }

    private int maxSumSubArray(int[] arr, int n, int k) {
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0, right = 0; i < n; i++) {
            right += arr[i];
            Integer left = bst.ceiling(right - k);
            if (left != null) {
                ans = Math.max(ans, right - left);
            }
            bst.add(right);
        }
        System.out.println(bst);
        return ans;
    }

    public static void main(String[] args) {
        Solution0827 s = new Solution0827();
        GridCodec g = new GridCodec();

        System.out.println(s.maxSumSubmatrix(g.getIntGrid("[[1,0,1],[0,-2,3]]"), 2));


    }
}
