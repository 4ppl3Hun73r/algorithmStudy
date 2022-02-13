package contest;

import java.util.Arrays;

public class Contest63 {

    public long minimumRemoval(int[] beans) {

        /*
        4,1,6,5 -> 4,0,4,4
        4

        2,10,3,2 -> 0,10,0,0
        7

        배열에서 0을 제외한 다른 값들을 동일하게 만들어야 함
        최소한의 수를 제거함으로써 만들어야함.

        배열을 정렬하고 min부터 해당 값을 기준으로 잡았을떄 제거해야 하는 콩의 수를 계산함.
        1, 4, 5, 6
        a, b, c, d

        0 -> b - a + c - a + d - a => b + c + d - 3a == a + b + c + d - 4a
        1 -> a + c - b + d - b => a + c + d - 2b == a + b + c + d  - 3b
        2 -> a + b + d - c  == a + b + c + d - 2c
        3 -> a + b + c == a + b + c + d  - d
         */

        Arrays.sort(beans);
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long result = Long.MAX_VALUE;
        long m = beans.length;
        for (int i = 0; i < beans.length; i++, m--) {
            result = Math.min(result, sum - m * beans[i]);
        }

        return result;

    }



    public static void main(String[] args) {
        Contest63 c = new Contest63();

    }
}
