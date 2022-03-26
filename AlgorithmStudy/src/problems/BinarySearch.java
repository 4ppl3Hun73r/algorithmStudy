package problems;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int len = nums.length;

        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();

        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, -1));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 0));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 3));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 5));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 12));
    }
}
