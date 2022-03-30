package y2022.mar;

public class Solution0329 {


    // y2022.jun.Solution0119.detectCycle 와 같은 문제로 해결 가능
    public int findDuplicate(int[] nums) {
        /*
        1 ~ N 까지 값이 있음
        하나만 2번 존재
        배열 수정 x
        constants extra space
        1 <= n <= 100000

        nums.length == n + 1
        1 <= nums[i] <= n

         */

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution0329 s = new Solution0329();

        System.out.println(s.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
