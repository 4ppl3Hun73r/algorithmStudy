package y2022.jul;


import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class Solution0725 {
    public int[] searchRange(int[] nums, int target) {
        /*
        정렬되어 있는 nums 가 있다.
        target 의 시작 ~ 종료 지점을 찾아라
        ex)
        1, 2, 2, 2, 2, 2, 5
           ^           ^
           S           E
                 ^
              ^
          pS => 답
        ^

        없으면 -1, -1

        O(log n) 으로 풀어야함
         */

        int start = Arrays.binarySearch(nums, target);
        int end = start;
        if (start < 0) {
            return new int[]{-1, -1};
        }

        int prevStart = start;
        while (start >= 0) { // o(log n)????
            prevStart = start;
            start = Arrays.binarySearch(nums, 0, start, target);
        }

        int prevEnd = end;
        while (end >= 0) { // o(log n)????
            prevEnd = end;
            end = Arrays.binarySearch(nums, end + 1, nums.length, target);
        }

        return new int[]{prevStart, prevEnd};
    }



    public static void main(String[] args) throws Exception {
        Solution0725 s = new Solution0725();

        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // 3, 4
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{0, 0}, 0)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,8}, 2)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,8}, 8)));
    }
}
