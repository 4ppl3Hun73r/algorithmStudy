package y2022.jun;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Solution0609 {
    public int[] twoSum(int[] numbers, int target) {
        // number 정렬되어 있음
        // 답은 무조건 한개만 존재
        /*

          [2,7,11,15]
             ^  ^
          [-10000, ....,0,1,.....,100,.. 100000]
          target + min -> binarysearch
          min + max = target
          target - min = max
          ifExist? ->
          for min -> O(n * logn)
          two point -> O(n)
           target = 9
         */
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum > target) {
                high--;
            } else if(sum < target) {
                low++;
            } else {
                break;
            }
        }

        return new int[]{low + 1, high + 1};
    }
}
