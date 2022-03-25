package y2022.mar;

// https://leetcode.com/problems/broken-calculator/
public class Solution0323 {
    public int brokenCalc(int startValue, int target) {
        /*
        startValue -> target 까지 최소한으로 가는 방법

        value 는 한번에 *2 또는 -1을 할수 있다.

        math 또는 greedy

        2, 3 : 2 -> 4 -> 3
        5, 8 : 5 -> 4 -> 8
        3, 10 : 3 -> 6 -> 5 -> 10
         */
        int step = 0;
        /*while (startValue != target) {
            if (startValue > target) {
                startValue--;
            } else {
                int div = target / 2;
                if (startValue >= div) {
                    startValue = startValue * 2;
                } else {
                    startValue--;
                }
            }
            step++;
        }*/
        /*
          2 -> 1 or 4
           1
           4 -> 3 or 8
           2^31 -> 21억
         */

        while (target > startValue) {
            if ((target % 2) == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            step++;
        }

        return step + (startValue - target);
    }

    public static void main(String[] args) throws Exception {
        Solution0323 s = new Solution0323();

        System.out.println(s.brokenCalc(2, 3)); // 2
        System.out.println(s.brokenCalc(5, 8)); // 2
        System.out.println(s.brokenCalc(3, 10)); // 3 10 -> 5 -> 6 -> 3 -> 3 + (start - target)
        System.out.println(s.brokenCalc(3, 1000000000));
        System.out.println(s.brokenCalc(1000000000, 1));
        System.out.println(s.brokenCalc(9411921, 9411923));
        //1000000000
        //1
    }
}
