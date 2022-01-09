package contest;

import java.util.Random;

public class Contest34 {
    public int minSwaps(int[] nums) {
        int windowSize = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                windowSize++;
            }
        }

        int zeroCnt = 0;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            }
        }
        int result = zeroCnt;
        for (int i = 1; i < len; i++) {
            if (nums[(i + windowSize - 1) % len] == 0) {
                zeroCnt++;
            }
            if (nums[i - 1] == 0) {
                zeroCnt--;
            }
            result = Math.min(result, zeroCnt);
        }

        return result;

    }

    public static void main(String[] args) {
        Contest34 c = new Contest34();

        //System.out.println(c.minSwaps(new int[]{0,1,0,1,1,0,0}));
        //System.out.println(c.minSwaps(new int[]{0,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,1}));

        Random random = new Random();
        int[] testCase = new int[100000];
        for (int i = 0; i < 100000; i++) {
            //testCase[i] = random.nextInt(2);
            System.out.print(random.nextInt(2));
            System.out.print(",");
        }
        //System.out.println(c.minSwaps())
    }
}
