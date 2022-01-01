package y2021.sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/
public class Solution0902 {

    public int arrayNesting(int[] nums) {

        // [2,1,0]
        // 0 -> 2
        // nums[0] -> nums[2] -> 2
        // nums[1] -> 0

        // nums[0] -> nums[2] -> nums[3] -> nums[4] -> nums[5] : max len => 5
        // nums[1] -> nums[0] -> 1 + 5 => 6
        // nums[2] -> max?

        // [2,0,4,5,1]  0 <= nums[i] <= nums.length;
        // 5,4,0,3,1,6,2
        // # i =0 , nums[i] = 5,

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int 현재인덱스 = i;
            int 다음인덱스 = nums[i];
            int count = 0;
            while (다음인덱스 != -1) {
                count++;
                int 임시인덱스 = 다음인덱스;
                nums[현재인덱스] = -1;
                다음인덱스 = nums[다음인덱스];
                현재인덱스 = 임시인덱스;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution0902 solution0902 = new Solution0902();
        System.out.println(solution0902.arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println(solution0902.arrayNesting(new int[]{0,1,2}));

    }
}
