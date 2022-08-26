package y2022.aug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/reordered-power-of-2/
public class Solution0826 {

    static Map<Integer, int[]> map = new HashMap<>();
    static {
        map.put(0, new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0});
        map.put(1, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0});
        map.put(2, new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0});
        map.put(3, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0});
        map.put(4, new int[]{0, 1, 0, 0, 0, 0, 1, 0, 0, 0});
        map.put(5, new int[]{0, 0, 1, 1, 0, 0, 0, 0, 0, 0});
        map.put(6, new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0, 0});
        map.put(7, new int[]{0, 1, 1, 0, 0, 0, 0, 0, 1, 0});
        map.put(8, new int[]{0, 0, 1, 0, 0, 1, 1, 0, 0, 0});
        map.put(9, new int[]{0, 1, 1, 0, 0, 1, 0, 0, 0, 0});
        map.put(10, new int[]{1, 1, 1, 0, 1, 0, 0, 0, 0, 0});
        map.put(11, new int[]{1, 0, 1, 0, 1, 0, 0, 0, 1, 0});
        map.put(12, new int[]{1, 0, 0, 0, 1, 0, 1, 0, 0, 1});
        map.put(13, new int[]{0, 1, 1, 0, 0, 0, 0, 0, 1, 1});
        map.put(14, new int[]{0, 1, 0, 1, 1, 0, 1, 0, 1, 0});
        map.put(15, new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0});
        map.put(16, new int[]{0, 0, 0, 1, 0, 2, 2, 0, 0, 0});
        map.put(17, new int[]{1, 2, 1, 1, 0, 0, 0, 1, 0, 0});
        map.put(18, new int[]{0, 1, 2, 0, 2, 0, 1, 0, 0, 0});
        map.put(19, new int[]{0, 0, 2, 0, 1, 1, 0, 0, 2, 0});
        map.put(20, new int[]{1, 1, 0, 0, 1, 1, 1, 1, 1, 0});
        map.put(21, new int[]{1, 1, 2, 0, 0, 1, 0, 1, 0, 1});
        map.put(22, new int[]{1, 1, 0, 1, 3, 0, 0, 0, 0, 1});
        map.put(23, new int[]{1, 0, 0, 1, 0, 0, 1, 0, 4, 0});
        map.put(24, new int[]{0, 2, 1, 0, 0, 0, 2, 3, 0, 0});
        map.put(25, new int[]{0, 0, 1, 3, 2, 2, 0, 0, 0, 0});
        map.put(26, new int[]{1, 1, 0, 0, 1, 0, 2, 1, 2, 0});
        map.put(27, new int[]{0, 2, 2, 1, 1, 0, 0, 2, 1, 0});
        map.put(28, new int[]{0, 0, 1, 1, 2, 2, 2, 0, 1, 0});
        map.put(29, new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 1});
        map.put(30, new int[]{1, 2, 1, 1, 2, 0, 0, 2, 1, 0});
        map.put(31, new int[]{0, 1, 1, 1, 3, 0, 1, 1, 2, 0});
        map.put(32, new int[]{0, 0, 2, 0, 2, 0, 2, 1, 0, 3});
        map.put(33, new int[]{0, 0, 1, 1, 1, 2, 0, 0, 2, 3});
        map.put(34, new int[]{0, 3, 0, 0, 1, 0, 1, 2, 2, 2});
    }

    public boolean reorderedPowerOf2(int n) {
        int[] nCount = getCount(n);

         for (int i = 0; i <= 34; i++) {
            int[] val = map.get(i);

            if(Arrays.equals(nCount, val)) {
                return true;
            }
            boolean result = true;
            for (int j = 0; j < 10; j++) {
                if (val[j] != nCount[j]) {
                    result = false;
                    break;
                }
            }
            if (result) {
                return true;
            }
        }

        return false;
    }

    //0 1 2 3

    private int[] getCount(long n) {
        int[] count = new int[10];

        for (char c : String.valueOf(n).toCharArray()) {
            count[c - '0']++;
        }//
        //2147483609
        //9999999999

        return count;
    }


    public static void main(String[] args) throws Exception {
        Solution0826 s = new Solution0826();

        System.out.println(Integer.MAX_VALUE);

        for (int i = 0; i < 35; i++) {
            System.out.print(i + " : ");
            System.out.println(Arrays.toString(s.getCount((long) Math.pow(2, i))));
        }
    }
}
