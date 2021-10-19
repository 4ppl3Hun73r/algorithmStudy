package problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = Arrays.binarySearch(nums, target);
        int end = start;
        if (start < 0) {
            return new int[]{-1, -1};
        }
        int prevStart = start;
        while (start >= 0) {
            prevStart = start;
            start = Arrays.binarySearch(nums, 0, start, target);
        }
        int prevEnd = end;
        while (end >= 0) {
            prevEnd = end;
            end = Arrays.binarySearch(nums, end + 1, nums.length, target);
        }

        return new int[]{prevStart, prevEnd};
    }

    public static void main(String[] args) throws Exception {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();

        System.out.println(Arrays.toString(f.searchRange(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 2)));

        /*
        System.out.println(Arrays.toString(f.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(f.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(f.searchRange(new int[]{}, 0)));
*/

    }
}
