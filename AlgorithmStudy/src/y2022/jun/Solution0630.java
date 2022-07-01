package y2022.jun;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
public class Solution0630 {

    public int minMoves2(int[] nums) {
        /*
        아래 와 비슷한데, x 를 nums 안에서 찾는 방식으로 접근해보자
        그렇다면 nums 의 중간 값을 x로 잡아야 한다.
         */

        // 중간 값을 찾기 위해 정렬
        Arrays.sort(nums);
        int x = nums[nums.length / 2];

        int move = 0;
        for (int num : nums) {
            move += Math.abs(num - x);
        }

        return move;

    }


    /*
    직관으로 모든 합의 중간이라고 한 부분에서 오류가 있어서 틀린것 같다.
    [1,0,0,8,6]
    -> 답은 14 인데 16으로 나옴
    답은 x == 1 일때 성립됨
     */
    public int minMoves2Fail(int[] nums) {
        /*
        nums[i] 에 +1 or -1 을 하면 move++
        Nums의 모든 값을 같게 만드는 최소한의 move를 찾아야한다.

        모든 nums[i] 값이 도달해야 하는 값을 x 라고 한다면

        x = nums[0] + a
        x = nums[1] + b
        x = nums[2] + c
        ...
        으로 되고

        l = nums.length

        l * x = sum(nums) + (a + b + ... ) 로 정리하고
        x = sum(nums) / l + (a + b + ... ) / l 로 할 수 있다.

        우리가 원하는 답은 move = |a| + |b| + ... 이 최소로 되는 것이다.
        move 가 최소가 되기 위해서는 직관적으로
        x = sum(nums) / l + (a + b + ... ) / l 에서 (a + b + ...) 이 0으로 수렴한다면 최소라 직관적으로 (증명은 못하지만) 가정한다면

        x = sum(nums) / l 로 표현 할 수 있고
        답은 |nums[0] - x| + |nums[1] - x|.... 으로 구할 수 있다.
         */
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int x = (int)(sum / nums.length);

        int move = 0;
        for (int num : nums) {
            move += Math.abs(num - x);
        }

        return move;
    }
}
