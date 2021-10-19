package problems;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        // nums is possibly rotated
        int len = nums.length;

        int start = 0;
        int end = len - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int t = nums[mid];
            if (t == target) {
                return mid;
            }

            //왼쪽 부터 중간까지는 정상 order
            if (nums[start] <= t) {
                //[4,5,6,7,0,1,2], n = 0, mid = 4
                // 찾으려는값이 왼쪽 영역에 있으면 탐색 범위를 [4,5,6,7] 로 변경
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    // 반대 위치에 있으면
                    // [0,1,2] 로 변경
                    start = mid + 1;
                }
            } else {
                // rotated 되긴 했는데 어디에서 걸렸나 모름
                // [3,4,5,6,7,0,1], n = 7, mid = 4
                // 아직 rotated 된 범위에 찾는 값이 있음
                if (target > nums[mid] && target <= nums[end]) {
                    // [7,0,1]
                    start = mid + 1;
                } else {
                    // [3,4,5]
                    end = mid - 1;
                }
            }
        }

        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args) throws Exception {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(s.search(new int[]{1}, 0));
    }
}
