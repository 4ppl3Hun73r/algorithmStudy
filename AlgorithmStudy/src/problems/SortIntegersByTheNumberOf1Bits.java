package problems;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        int[][] arr2 = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = new int[2];
            arr2[i][0] = arr[i];
            arr2[i][1] = Integer.bitCount(arr[i]);
        }

        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[1]);
        comparator = comparator.thenComparing(Comparator.comparingInt(o -> o[0]));

        Arrays.sort(arr2, comparator);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i][0];
        }

        return arr;

    }
}
