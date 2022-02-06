package contest;

import java.util.Arrays;

public class Contest60 {

    public int minimumTime(String s) {
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];

        boolean jump = s.charAt(0) == '0';
        left[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            char car = s.charAt(i);
            if (car == '1') {
                left[i] = left[i - 1] + (jump ? 2 : 1);
                left[i] = Math.min(left[i], i + 1);
            } else {
                jump = true;
                left[i] = left[i - 1];
            }
        }
        jump = s.charAt(len - 1) == '0';
        right[len - 1] = s.charAt(len - 1) == '1' ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            char car = s.charAt(i);
            if (car == '1') {
                right[i] = right[i + 1] + (jump ? 2 : 1);
                right[i] = Math.min(right[i], len - i);
            } else {
                jump = true;
                right[i] = right[i + 1];
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        if (len == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            min = Math.min(left[i] + right[i + 1], min);
        }

        return min;

    }

    public static void main(String[] args) {
        Contest60 c = new Contest60();

        //System.out.println(c.minimumTime("1100101"));
        System.out.println(c.minimumTime("0111001110")); // 8


    }
}
