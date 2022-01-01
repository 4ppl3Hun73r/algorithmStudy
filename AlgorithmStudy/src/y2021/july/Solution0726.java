package y2021.july;

import java.util.function.Function;

public class Solution0726 {
    public int findIntegers(int num) {
        // index = input(n)
        // dp[0] = 1, dp[1] = 2, dp[2] = 3, dp[3] = 3, dp[4] = 4, dp[5] = 5, dp[6] = 5, dp[7] = 5, dp[8] = 6,
        // dp[0] = 1, dp[1] = 2, dp[2] = 3, dp[3] = 3, dp[4] = 4, dp[5] = 5, dp[6] = 5, dp[7] = 5, dp[8] = 5,
        // f[0] = 1, f[1] = 2, f[2] = 3, f[3] = 5, f[4] = 8, f[5] = 13
        // 1, 10, 11, 101, 1000, 1101
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        //2의 배수의 정답... 0, 1, 2, 4, 8, 16,
        for (int i = 2; i < f.length; i++)
            f[i] = f[i - 1] + f[i - 2];

        int i = 30, sum = 0, prev_bit = 0;
        while (i >= 0) {
            if ((num & (1 << i)) != 0) {
                // num = 10, 1010
                // 1 << 30 => 1000000000000000000
                // 1 << 3 => 1000 => 1
                // 11
                // 8 -> 1000
                // 9 -> 1001
                // 10 -> 1010

                // 10000
                //  1000
                //   100
                //     10
                sum += f[i];   // 0, f[3] = 5
                // 11 찾기
                if (prev_bit == 1) {
                    sum--;
                    break;
                }
                prev_bit = 1;
            } else
                prev_bit = 0;
            i--;
        }

        return sum + 1; ///  0 케이스
    }


    public static void main(String[] args) throws Exception {
        int x = 5;
        //
        System.out.println(x & (1 << 31));
        System.out.println(x & (1 << 30));
        System.out.println(x & (1 << 29));


        Function<Integer, Integer> t = (n) -> {
            int count = 5;
            for (int i = 0; i <=n ; i++) {
                String a = Integer.toBinaryString(i);
                if (a.indexOf("11") > 1) {
                    count --;
                }
            }

            return count;
        };
    }
}
//https://code-with-me.jetbrains.com/B4NjwKjLDgRZ1bS0tInnzg#p=IU&fp=8C49FF7821608928627348BE199CD6B43992C72601FFE312DBE28B137EAA29E6
//https://code-with-me.jetbrains.com/ncX3tbvOuzTQ_6CqITzzhA#p=IU&fp=8C49FF7821608928627348BE199CD6B43992C72601FFE312DBE28B137EAA29E6


// index = input(n)
// dp[0] = 1, dp[1] = 2, dp[2] = 3, dp[3] = 3, dp[4] = 4, dp[5] = 5, dp[6] = 5, dp[7] = 5, dp[8] = 6,

// dp[0] = 1, dp[1] = 2, dp[2] = 3, dp[3] = 3, dp[4] = 4, dp[5] = 5, dp[6] = 5, dp[7] = 5, dp[8] = 5,

/*
0	0000
1	0001
2	0010
3	0011			a 2^2 - 2^0
4	0100
5	0101                                                           5 = 2^-1
6	0110			b 2^3 - 2^1                                    6 = 2^2-1)
7	0111			a 2^3 - 2^0             110 101 100 011 010... -> 8 =(2^-1) - 2^1 - 2^0 + 1
8	1000
9	1001
10	1010
11	1011
12	1100
13	1101
14	1110
15	1111
16	10000
17	10001
18	10010
19	10011
20	10100
21	10101
22	10110
23	10111
24	11000		b 2^5 -2^3
25	11001
26	11010
27	11011
28	11100		b 2^5 -2^2
29	11101
30	11110		b 2^5 -2^1
31	11111		a 2^5 -2^0
*/

/** f[0] = 1
 0 - 0
 */
/** f[1] = 2
 0 - 0
 1 - 1
 */
/** f[2] = f[1] + f[0] = 2 + 1 = 3
 0 - 0
 1 - 1
 2 - 10
 3 - 11
 */
/** f[3] = f[2] + f[1] = 3 + 2 = 5
 0 - 0
 1 - 1
 2 - 10
 3 - 11
 4 - 100
 5 - 101
 6 - 110
 7 - 111
 */
/** f[4] = f[3] + f[2] = 5 + 3 = 8
 0 - 0
 1 - 1
 2 - 10
 3 - 11
 4 - 100
 5 - 101
 6 - 110
 7 - 111
 8 - 1000
 9 - 1001
 10 - 1010
 11 - 1011
 12 - 1100
 13 - 1101
 14 - 1110
 15 - 1111
 */
/** f[5] = f[4] + f[3] = 8 + 5 = 13
 0 - 0
 1 - 1
 2 - 10
 3 - 11
 4 - 100
 5 - 101
 6 - 110
 7 - 111
 8 - 1000
 9 - 1001
 10 - 1010
 11 - 1011
 12 - 1100
 13 - 1101
 14 - 1110
 15 - 1111
 16 - 10000
 */
