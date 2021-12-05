package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Contest1 {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        int[] digitCnt = new int[10];

        for (int digit : digits) {
            if (digitCnt[digit] < 3) {
                digitCnt[digit]++;
            }
        }

        for (int i = 0; i < 10; i+= 2) {
            if (digitCnt[i] != 0) {
                digitCnt[i] --;

                for (int j = 0; j < 10; j++) {
                    if (digitCnt[j] != 0) {
                        digitCnt[j] --;

                        for (int k = 1; k < 10; k++) {
                            if (digitCnt[k] != 0) {
                                result.add(k * 100 + j * 10 + i);
                            }
                        }
                        digitCnt[j] ++;
                    }
                }
                digitCnt[i] ++;
            }
        }

        int[] resultArr = result.stream().mapToInt(i -> i).toArray();
        Arrays.sort(resultArr);

        return resultArr;

    }

    public static void main(String[] args) {
        Contest1 c = new Contest1();

        System.out.println(Arrays.toString(c.findEvenNumbers(new int[]{2,1,3,0})));
        System.out.println(Arrays.toString(c.findEvenNumbers(new int[]{2,2,8,8,2})));
        System.out.println(Arrays.toString(c.findEvenNumbers(new int[]{3,7,5})));
        System.out.println(Arrays.toString(c.findEvenNumbers(new int[]{0,0,0,2})));
        System.out.println(Arrays.toString(c.findEvenNumbers(new int[]{0,0,0})));
    }
}
