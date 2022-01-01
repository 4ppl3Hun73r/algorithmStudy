package y2021.nov;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
public class Solution1111 {
    public int minStartValue(int[] nums) {
        // 계속 더해 갈때 언제나 양수가 되는 최초 시작 값중 min을 찾으세요.
        /*
        [-3,2,-3,4,2] 5
     n=1 -2 X
       2 -1 X
       3  0 X
       4  1 3  0 X
       5  2 4  1 5 7 O
        [1,2] 1
        [1,-2,-3] 5
        "Prefix Sum"
        min = 0;
        [-3, -1 -4, 0, -2] => |min, -4| + 1
        [1,-1,-4] => |min, -4| + 1
        [1,3] => |min, 0| + 1
         */

        int min = Math.min(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1]; // 배열?
            min = Math.min(nums[i], min);
        }
        return (min * -1) + 1;
    }
// 고생ㅎㅏ셨습니다~~~* thanks~  bbbb

    public static void main(String[] args) throws Exception {
        Solution1111 solution1111 = new Solution1111();
        System.out.println(solution1111.minStartValue(new int[]{-3,2,-3,4,2})); // 5
        System.out.println(solution1111.minStartValue(new int[]{1,2})); // 1
        System.out.println(solution1111.minStartValue(new int[]{1,-2,-3})); // 5
    }
}
