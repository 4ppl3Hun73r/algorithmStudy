package contest;

import java.util.Arrays;

public class Contest16 {
    public int kIncreasing(int[] arr, int k) {
        int oper1 = 0;
        int oper2 = 0;

        int[] o = Arrays.copyOf(arr, arr.length);
        for (int i = arr.length - 1 - k; i >= 0; i--) {
            int right = arr[i + k];
            int center = arr[i];

            if (center <= right) {
                continue;
            }
            // 오른쪽하고만 맞추면 됨
            arr[i] = right;
            oper1 ++;
        }
        for (int i = 0; i < o.length - k; i++) {
            int center = o[i];
            int right = o[i + k];

            if (center <= right) {
                continue;
            }
            o[i] = right;
            oper2 ++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(o));

        return Math.min(oper1, oper2);
    }

    public static void main(String[] args) {
        Contest16 c = new Contest16();

        System.out.println(c.kIncreasing(new int[]{12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3}, 1));
    }
}
