package y2023.apr;

// https://leetcode.com/problems/bulb-switcher/
public class Solution0427 {
    public int bulbSwitch(int n) {
        /*
            n = 5
            OOOOO
            0X0X0
            0XXX0
            0XX00
            0XX0X -> 답: 2

            0000000000
            0X0X0X0X0X
            0XXX0X0XX0
            0       : 0
            1       : 1
            2       : 1
            3       : 1
            4,5,6,7,8 : 2

            9 ~  15 : 답 3
            16 ~ 24 : 답 4
            25 ~ 35 : 답 5
            36 ~ 49 : 답 6
         */
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) throws Exception {
        Solution0427 s = new Solution0427();

        for (int i = 0; i <= 49; i++) {
            System.out.println(i + ":" + s.bulbSwitch(i));
        }

    }
}
