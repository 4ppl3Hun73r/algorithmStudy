package problems;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
public class FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {

        int len = chalk.length;
        long sum = 0;
        long k2 = k;
        long[] prefixSum = new long[len];
        for (int i = 0; i < len; i++) {
            sum += chalk[i];
            if (i == 0) {
                prefixSum[0] = chalk[0];
            } else {
                prefixSum[i] = prefixSum[i - 1] + chalk[i];
            }
        }

        k2 = k2 % sum;

        if (k2 == 0) {
            return 0;
        }

        int pos = Arrays.binarySearch(prefixSum, k2);
        if (pos < 0) {
            pos = -pos - 1;
        } else {
            pos ++;
        }

        /*
        [3,4,1,2], k = 25


        [3, 7, 8, 10]

        k = 5
         */

        System.out.println(Arrays.toString(prefixSum));
        System.out.println(pos);

        return pos;

    }

    public static void main(String[] args) {
        FindTheStudentThatWillReplaceTheChalk f = new FindTheStudentThatWillReplaceTheChalk();

        System.out.println(f.chalkReplacer(new int[]{3,4,1,2}, 25));
    }
}
