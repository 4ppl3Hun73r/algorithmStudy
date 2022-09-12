package y2022.sep;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
public class Solution0903 {
    public int[] numsSameConsecDiff(int n, int k) {
        /*
        n개의 자리에 대해서
         각 자리는 k 개의 차이가 있어야 한다.
         0 은 안됨.

         */
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            conseDiff(i, i,n - 1, k, list);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void conseDiff(int num, int lastNum, int n, int k, List<Integer> list) {
        if (n == 0) {
            list.add(num);
            return ;
        }

        int t = lastNum - k;
        if (t >= 0) {
            conseDiff(num * 10 + t, t, n - 1, k, list);
        }

        int t2 = lastNum + k;
        if (t2 < 10 && t != t2) {
            conseDiff(num * 10 + t2, t2, n - 1, k, list);
        }

    }

    public static void main(String[] args) {

        Solution0903 s = new Solution0903();



        //System.out.println(Arrays.toString(s.numsSameConsecDiff(2, 1)));

        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println(i);
                System.out.println(j);
            }
            
        }
    }



}
