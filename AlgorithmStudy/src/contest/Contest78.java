package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Contest78 {

    public int[] sortJumbled(int[] mapping, int[] nums) {

        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
        comparator = comparator.thenComparingInt(o -> o[1]);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);


        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int mappedNum = 0;
            int digit = 1;
            do {
                int m = num % 10;
                num = num / 10;
                mappedNum += mapping[m] * digit;
                digit = digit * 10;
            } while(num != 0);

            priorityQueue.add(new int[]{mappedNum, i});
        }

        System.out.println(priorityQueue);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[priorityQueue.poll()[1]];
        }

        return ans;

    }


    public static void main(String[] args) {
        Contest78 c = new Contest78();

        // [9,8,7,6,5,4,3,2,1,0]
        System.out.println(Arrays.toString(c.sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0},
                new int[]{0,1,2,3,4,5,6,7,8,9})));
                // 9,8,7,6,5,4,3,2,1,0

    }
}
