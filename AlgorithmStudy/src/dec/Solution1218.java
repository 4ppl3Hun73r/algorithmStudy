package dec;

import java.util.Arrays;

// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
public class Solution1218 {
    public int atMostNGivenDigitSet(String[] digits, int n) {

        String nStr = String.valueOf(n);
        int len = nStr.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;

        /*
          n 이 551이라고 할때, 1, 3, 5, 7
          100 ~ 551 까지의 수를 구한다.
          100 -> 4 * 4
          300 -> 4 * 4
          500 -> ==> 51 로 만들수 있는 조합

          10 ~ 51 까지의 조합
          10 -> 4
          30 -> 4
          50 -> 1 로 만들 수 있는 조합

          1 ~ 1 까지의 조합
          1 -> 1
         */
        for (int i = len - 1; i >= 0; i--) {
            int nD = nStr.charAt(i) - '0';
            for (String s : digits) {
                int dD = Integer.parseInt(s);
                if (dD < nD) {
                    dp[i] += Math.pow(digits.length, len - i - 1);
                } else if (nD == dD) {
                    dp[i] += dp[i + 1];
                }
                // dp[i]++;
            }
            // dp[i] = dp[i + 1] * (int)Math.pow(dp[i], len - i - 1);
            /*
            1, 3, 5, 7
            151
            100 ~ 151
            111, 113, 115, 117
            131, 133, 135, 137
            151, /// 153, 155, 157
             */
        }
        System.out.println(Arrays.toString(dp));


        // n 자리 수면
        // n - 1 까지는 공식으로 구할수 있지 않을까?
        // n 10, cnt : digits.length
        // n 100, cnt : digits.length + digits.length * digits.length
        // n 1000, cnt : digits.length + digits.length * digits.length + digits.length * digits.length * digits.length
        // 자리수 구해서 dp[0] 에 더해 놓기
        for (int i = 1; i < len; i++) {
            dp[0] += Math.pow(digits.length, i);
        }

        System.out.println(Arrays.toString(dp));

        /*
        int digit = 0;
        int num = n;
        while(num > 0) {
            num = num / 10;
            digit++;
        }
        int count = 0;
        int c = 1;
        int start = 1;
        for (int i = 1; i < digit; i++) {
            c *= digits.length;
            count += c;
            start *= 10;
        }
        //System.out.println(count);
        //System.out.println(start);

        for (int i = 0; i < digits.length; i++) {
            int d = n % 10;
            int m = 0;
            for (String s : digits) {
                if (d < s.charAt(0) - '0') {
                    break;
                }
                m++;
            }
            count += m * Math.pow(digits.length, digits.length - i);
        }

        /*
        1, 3, 5, 7
        111 <= 158 <= 177
        1보다 작은 수를 세고
        1 * 5보다 작은 수를 세고 2
        111, 113, 115, 117
        131, 133, 135, 137
        151, 153, 155, 157

        7 <= 8 -> 4개
        5 <= 5 -> 3개
        -> 12

        150 이면
        0 -> 9로 바꿔서 처리 9보다 작은것 -> 4개
        4 <= 4 -> 2개
        -> 4 * 2 -> 8개


        --- 151
        한자리 남았을때 한자리보다 작은 것의 수 ???

        151 ->
        1 * 3 * 1 -> 3개 ??


         */

        return dp[0];
    }

    public static void main(String[] args) {
        Solution1218 s = new Solution1218();
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100));  // 20
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 151));  // 20
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 551));  // 20
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000)); // 29523
        System.out.println(s.atMostNGivenDigitSet(new String[]{"7"}, 8));  // 1
        System.out.println(s.atMostNGivenDigitSet(new String[]{"9"}, 8));  // 0
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","4","9"}, 900303902));  // 22962
    }
}
