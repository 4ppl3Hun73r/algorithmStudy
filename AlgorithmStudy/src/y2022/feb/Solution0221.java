package y2022.feb;

// https://leetcode.com/problems/majority-element/
public class Solution0221 {
    public int majorityElement(int[] nums) {
        /*
        문제는 easy 만
        follow up 을 만족하려면 난이도가 높아진다.
         -> 만족할려면 특정 알고리즘을 알아야한다.

         과반을 찾는 알고리즘이 존재

         Boyer-Moore Voting Algorithm
         */
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num; // bb
            }
            count += (num == candidate) ? 1 : -1; // bb
        }

        /*
              2,2,1,1,1,2,2
        count 1 2 1 0 1 0 1
        candi 2 2 2 2 1 2 2 -> 최종적으로 2가 과반이 된다.

        2,2,3,3,2,2,1,1,2,2,2,1,1,1

        1,1,1,2,2,2,3,3,3,3,3,3
        Arrays.sort(nums);
        return nums[nums.length/2];
         */

        return candidate;
    }
}
