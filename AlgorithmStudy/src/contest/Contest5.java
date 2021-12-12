package contest;

import java.util.Arrays;
import java.util.Comparator;

public class Contest5 {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] node = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            node[i] = new int[]{nums[i], i};
        }

        Arrays.sort(node, (a, b) -> b[0] - a[0]);
        int[] result = new int[k];
        int[][] temp = new int[k][];

        for (int i = 0; i < k; i++) {
            temp[i] = node[i];
        }
        Arrays.sort(temp, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < k; i++) {
            result[i] = temp[i][0];
        }

        return result;
    }

    public static void main(String[] args) {
        Contest5 c = new Contest5();

        System.out.println(Arrays.toString(c.maxSubsequence(new int[]{50, -75}, 2)));
    }
}
