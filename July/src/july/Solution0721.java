package july;

import java.util.Random;

public class Solution0721 {
    int[] original;
    Random random;

    public Solution0721(int[] nums) {
        this.original = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = original.clone();
        for (int i = 0; i < shuffle.length; i++) {
            swap(shuffle, i, random.nextInt(shuffle.length));
        }
        for (int i = 0; i < shuffle.length; i++) {
            // swap(shuffle, i, );
            // random.nextInt(shuffle.length) > i
        }
        for (int i = shuffle.length - 1; i >= 0; i--) {
            swap(shuffle, i, random.nextInt(i + 1));
        }

        // -6, 10, 184

        // i = 2, rand.next(3) => 1, 2 = -6, 10,
        //=>  i = 2, rand.next(3) => 0, 1, 2 = -6, 10, 184
        // i = 1, rand.next(1) => -6

        // j = 0, rand.next(3 - 0) + 0 => rand.next(3) + 0 => '0,' 1, 2
        // j = 1, rand.next(3 - 1) + 1 => rand.next(2) + 1 => '1,' 2
        // j = 2, rand.next(3 - 2) + 2 => rand.next(1) + 2 => '2'

        // k = 0, rand.next(3) => 0, 1, 2
        // k = 1, rand.next(3) => 0, 1, 2
        // k = 2, rand.next(3) => 0, 1, 2

        return shuffle;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


