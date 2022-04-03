package y2022.apr;

// https://leetcode.com/problems/next-permutation/
public class Solution0403 {
    public void nextPermutation(int[] nums) {
        //nums : [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
        // The next permutation of an array of integers is the next lexicographically greater permutation
        // 1,2,3 -> 1,3,2
        // 3,2,1 -> 1,2,3
        // 1,1,5 -> 1,5,1
        // The replacement must be in place and use only constant extra memory.

        /*
        two pointers
        [5,4,3,2,1] -> [1,2,3,4,5]
        [5,4,3,1,2] -> [5,4,3,2,1]

        [5,4,1,2,3,6] -> [5,4,1,2,6,3]
        [5,4,3,6,1,2] -> [5,4,3,6,2,1]
         */

        int i = nums.length - 2;
        // 바꿀 값 찾기
        for (; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                break;
            }
        }

        if (i >= 0) {
            // 자기보다 큰거랑 스왑
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }

        // 스왑한곳 뒤는 뒤집기
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution0403 s = new Solution0403();

        s.nextPermutation(new int[]{1,3,2}); // 2,1,3
    }
}
