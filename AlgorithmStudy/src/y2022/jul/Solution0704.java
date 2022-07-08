package y2022.jul;

import java.util.Arrays;

// https://leetcode.com/problems/candy/
public class Solution0704 {
    public int candy(int[] ratings) {
        /*
        rating 에 따라 캔디를 나눠줘야 한다.
        가장 적게 캔디를 나눠줄수 있는 경우를 계산하여 나눠준 캔디 수를 반환해라.

        캔디를 나눠주는 규칙
         1. 최소한 1개 이상은 줘야함
         2. 양옆보다 점수가 높다면 캔디를 더 받아야함

        [1,0,2]
           1
         2,1,2  => 5

        [1,2,2]
         1
         1,2,
         1,2,1 => 4, 점수가 동일하기 때문에 낮게 받아도 상관 없음

         1 <= length <= 20000
         0 <= ratings[i] <= 20000


         [1,2,3,4,5,6,7,8]
          1 2 3 4 5 6 7 8

          1,2,3,4,3,2,1
          1 2 3 4 3 2 1

          1. 최소값들을 찾아서 거기서 부터 시작?

          Greedy.

          1. 왼쪽으로 한번 탐색, 오른쪽으로 한번 탐색?


          [1,0,1,1,1,1,0,1,1,1]  ->
             1         1
           2   2     2   2
                 1 1       1
                             1

           1,1,1,1,1,1,1,1,1,1

           2,1,2,1,1,2,1,2,1,1

        1 2 1
        l m r

        1 0 2
        1 1 1

        1 1 2
        2 1 1

           1,2,2
          l1 1 1
           1 2 1

          r1 1 1
           1 1 1

           1 2 1


        3 2 3 4 5
        1 1 2 3 4
        2 1 1 1 1

           1,2,2,1,2,2
           1 2 1 1 2 1


           1 2

         */

        int[] candyLeft = new int[ratings.length];
        int[] candyRight = new int[ratings.length];
        Arrays.fill(candyLeft, 1);
        Arrays.fill(candyRight, 1);

        for (int i = 1; i < candyLeft.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candyLeft[i] = candyLeft[i-1] + 1;
            }
        }

        for (int i = candyRight.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyRight[i] = candyRight[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(candyLeft[i], candyRight[i]);
        }
        return sum;
    }
}
