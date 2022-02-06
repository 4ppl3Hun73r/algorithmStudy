package contest;

import java.util.PriorityQueue;

public class Contest57 {
    public int[] sortEvenOdd(int[] nums) {
        // 홀수는 감소
        // 짝수는 증가


        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> even = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                nums[i] = even.poll();
            } else {
                nums[i] = odd.poll();
            }
        }

        return nums;


    }

    public static void main(String[] args) {
        Contest57 c = new Contest57();

    }
}
