package problems;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        while (left < right) {
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                right --;
            } else if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                left ++;
            }
        }
        // left / right is min point
        System.out.println(nums[left] + "," + nums[right]);

        int index = 0;
        result[index++] = nums[left] * nums[left];
        left--; right++;
        for (int i = 1; i < nums.length; i++) {
            if (left < 0) {
                result[index++] = nums[right] * nums[right];
                right++;
                continue;
            }
            if (right == nums.length) {
                result[index++] = nums[left] * nums[left];
                left--;
                continue;
            }
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                result[index++] = nums[left] * nums[left];
                left--;
            } else if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                result[index++] = nums[right] * nums[right];
                right++;
            }
        }

        // 너무 복잡하게 생각했네 그냥 큰수부터 찾아서 넣으면 되는데 작은수 부터 채우는거에 집차하다가 복잡해짐 ㅠ

        return result;
    }

    public int[] sortedSquares2(int[] nums) {
        int left =  0;
        int right = nums.length - 1;
        int len = nums.length;
        int result[] = new int[len];

        for(int i = len - 1; i >= 0; i--) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] =  nums[left] * nums[left];
                left++;
            } else {
                result[i] =  nums[right] * nums[right];
                right--;
            }
        }

        for(int i = 0; i < len ; i++) {
            nums[i] = result[i];
        }
        return nums;
    }

    public static void main(String[] args) throws Exception {
        SquaresOfASortedArray s = new SquaresOfASortedArray();

        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, -3, 3, 3})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, -3, 3, 3, 3})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, 2, 3, 11, 12})));
    }
}
