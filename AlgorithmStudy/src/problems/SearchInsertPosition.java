package problems;

import java.util.Arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            //System.out.println("" + start + "," + end + "," + mid);
            int t = nums[mid];
            //System.out.println(String.format("%d %d %d", start, half, t));
            if (t == target) {
                return mid;
            }
            if (t > target) {
                end = mid - 1;
            }
            if (t < target) {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws Exception {
        SearchInsertPosition s = new SearchInsertPosition();

        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 6)); // 3
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7)); // 4
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 0)); // 0
        System.out.println(s.searchInsert(new int[]{1}, 0)); // 0
        System.out.println(s.searchInsert(new int[]{1}, 2)); // 1
        System.out.println(s.searchInsert(new int[]{1,3}, 4)); // 2
    }


}
