package problems;

// https://leetcode.com/problems/single-number-ii/
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        /*
        linear runtime
        constant extra space
        [2, 2, 3, 2] -> 2
        [0, 1, 0, 1, 0, 1, 0, 99] -> 99
        https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers

        K 번의 Element가 무조건 나오고 (k > 1)
        P 번의 Element가 p >= 1 and p % k != 0 의 조건으로 나올때

        for (int i : nums) {
            xm ^= (xm-1 & ... & x1 & i);
            xm-1 ^= (xm-2 & ... & x1 & i);
            .....
            x1 ^= i;

            mask = ~(y1 & y2 & ... & ym) where yj = xj if kj = 1, and yj = ~xj if kj = 0 (j = 1 to m).

            xm &= mask;
            ......
            x1 &= mask;
        }

        와.. 설명이 이해가 안되네 그냥 sudo 코드를 외울까.. ㅠ

        다른 코드 설명을 보니
        x1 = one,
        x2 = two
        mask = three 로 해서 표현한게 있음
         */

        int x1 = 0;
        int x2 = 0;
        int mask = 0;

        for (int n : nums) {
            x2 = x2 ^ (x1 & n);
            x1 = x1 ^ n;

            mask = ~(x1 & x2);

            x2 &= mask;
            x1 &= mask;
        }

        return x1;
    }

    public static void main(String[] args) {
        SingleNumber2 s = new SingleNumber2();

        System.out.println(s.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(s.singleNumber(new int[]{0,1,0,1,0,1,99,99,99,100}));
    }
}
