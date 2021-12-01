package problems;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // k번째 큰수 찾기
        // [3,2,3,1,2,4,5,5,6]
        // [1,2,2,3,3,4,5,5,6] k =4, 4
        // Quick Selection

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // high보다 작은 것들 low ~ high 까지 채움
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot++, i);
            }
            /*
            [3,2,3,1,2,4,5,5,6]
            ...
            [3,2,3,1,2,4,5,5,6]
            6은 하위가 정렬이 어떻게 되는지는 상관없지만 맞는 index임
             */
        }
        // high의 위치 선정
        swap(nums, pivot, high);


        int count = high - pivot + 1;
        if (count == k) {
            // 만약 6이 찾는 값이었으면 high == pivot + 1 -> 1
            // k는 1이 었으니까 맞음
            return nums[pivot];
        }
        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }
        // 이미 등수가 정해져 있는 영역은 제외하고 찾기를 해야함
        // 등수(count)가 정해졌으니까 그 부분은 정리하고 찾기
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
