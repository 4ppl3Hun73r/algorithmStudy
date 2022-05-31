package y2022.may;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class Solution0527 {
    public int numberOfSteps(int num) {
       /*
       짝수면 나누고
       홀수면 1 빼고

       0이 될때까지
        */

        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
                // num >> 1
            } else {
                num--;
                // num num xor 1
            }
            step++;
            /*// 홀수면 +2
            // 짝수면 +1
            if (num % 2 == 0) {
                step = step + 1;
            } else {
                step = step + 2;
            }
            num = num >> 1;*/
        }

        return step;
    }

    public static void main(String[] args) throws Exception {
        Solution0527 s = new Solution0527();

        System.out.println(s.numberOfSteps(14));//6
        System.out.println(s.numberOfSteps(8));//4
        System.out.println(s.numberOfSteps(123));//12
    }
}
