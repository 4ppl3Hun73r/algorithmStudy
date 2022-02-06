package contest;

import java.util.LinkedList;
import java.util.Queue;

public class Contest54 {
    public int[] pivotArray(int[] nums, int pivot) {


        // pivot 보다 작은건 왼쪽
        // pivot 보가 큰건 오른쪽
        // 왼쪽 오른쪽 간의 순서는 지켜져야 한다.

        Queue<Integer> less = new LinkedList<>();
        Queue<Integer> equals = new LinkedList<>();
        Queue<Integer> greater = new LinkedList<>();


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                less.add(nums[i]);
            } else if (nums[i] > pivot) {
                greater.add(nums[i]);
            } else {
                equals.add(nums[i]);
            }
        }

        int idx = 0;
        while (!less.isEmpty()) {
            nums[idx++] = less.poll();
        }
        while (!equals.isEmpty()) {
            nums[idx++] = equals.poll();
        }
        while (!greater.isEmpty()) {
            nums[idx++] = greater.poll();
        }

        return nums;
    }

    public static void main(String[] args) {
        Contest54 c = new Contest54();

    }
}
