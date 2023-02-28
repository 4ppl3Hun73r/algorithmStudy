package y2023.feb;

// https://leetcode.com/problems/shuffle-the-array/
public class Solution0206 {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffle = new int[2 * n];

        for(int i = 0, j = 0; i < n; i++, j+=2) {
            shuffle[j] = nums[i];
            shuffle[j + 1] = nums[i + n];
        }

        return shuffle;
    }

    /*public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }

    public int[] shuffle(int[] nums, int n) {
        // Store each y(i) with respective x(i).
        for (int i = n; i < 2 * n; ++i) {
            int secondNum = nums[i] << 10;
            nums[i - n] |= secondNum;
        }

        // '0000000000 1111111111' in decimal.
        int allOnes = (int) Math.pow(2, 10) - 1;

        // We will start putting all numbers from the end,
        // as they are empty places.
        for (int i = n - 1; i >= 0; --i) {
            // Fetch both the numbers from the current index.
            int secondNum = nums[i] >> 10;
            int firstNum = nums[i] & allOnes;
            nums[2 * i + 1] = secondNum;
            nums[2 * i] = firstNum;
        }
        return nums;
    }*/
}

