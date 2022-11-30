package y2022.nov;

import java.util.Arrays;
import java.util.Random;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class Solution1111 {
    public int removeDuplicates(int[] nums) {
        int[] idx = new int[1];

        return (int) Arrays.stream(nums).distinct()
                .map(i -> nums[idx[0]++] = i)
                .count();
    }

    public int removeDuplicatesFast(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]){
                nums[j++] = nums[i+1];
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        Solution1111 s = new Solution1111();

        Random r = new Random();
        int len = 1000000;
        int[] temp1 = new int[len];
        int[] temp2 = new int[len];
        for (int i = 0; i < len; i++) {
            temp1[i] = r.nextInt();
            temp2[i] = temp1[i];
        }
        Arrays.sort(temp1);
        Arrays.sort(temp2);

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);
        long time = System.currentTimeMillis();
        System.out.println(s.removeDuplicates(temp1));
        System.out.println("stream: " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        System.out.println(s.removeDuplicatesFast(temp2));
        System.out.println("for: " + (System.currentTimeMillis() - time));
    }
}
