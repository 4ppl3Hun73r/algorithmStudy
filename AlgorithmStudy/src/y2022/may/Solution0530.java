package y2022.may;


// https://leetcode.com/problems/divide-two-integers/
public class Solution0530 {

    // 문제가 별로 풀고 싶지 않아.....
    public int divide(int dividend, int divisor) {
        if (-2147483648 == dividend && -1 == divisor) {
            return 2147483647;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        Solution0530 s = new Solution0530();
        System.out.println(s.divide(21312412, 2));
    }
}
