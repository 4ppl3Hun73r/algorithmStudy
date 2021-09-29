package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3990/
public class Solution0929 {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i%2) == 0 && (nums[i]%2) == 1) {
                // 짝수 번째 인데, 홀수가 있을때
                for (int j = i + 1; j < nums.length; j++) {
                    if ((nums[j]%2) == 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            } else if((i%2) == 1 && (nums[i]%2) == 0) {
                // 홀수 번째 인데, 짝수가 있을때
                for (int j = i + 1; j < nums.length; j++) {
                    if ((nums[j]%2) == 1) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }

        return nums;
    }

    public int[] doublePointer(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= nums.length - 1 && end >= 0) {
            int s = nums[start];
            int e = nums[end];

            if ((start%2) == 0 && (s%2) == 0) {
                start += 2;
                continue;
            }
            if ((end%2) == 1 && (e%2) == 1) {
                end -= 2;
                continue;
            }

            // 여기까지 오면 start / end 가 맞지않다.

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start+=2;
            end-=2;
        }
        // [4,1,2,1]
        // [  ^ ^
        // [4,2,1,1] -> 요걸로
        // [4,1,2,1]

        // [4,2,5,7]
        //    ^ ^
        // [4,2,5,7]
        // [4,5,2,7]

        return nums;
    }

    public int[] sortArrayByParityII2(int[] A){
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
