package y2021.dec;

// https://leetcode.com/problems/number-complement/
public class Solution1227 {
    public int findComplement(int num) {
        /*
            num = 5 -> '101'
                = 2 -> '010'
            num = 1 -> '1'
                = 0 -> '0'
            num = 16 -> '10000'
                = 15 -> '01111'
         */
        long start = System.nanoTime();
        char[] s = Integer.toBinaryString(num).toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                s[i] = '1';
            } else {
                s[i] = '0';
            }
        }
        System.out.println("string time : " + (System.nanoTime() - start));
        System.out.println("string: " + Integer.parseInt(new String(s), 2)); // int value
        // xor ->  a ^ b // 101 ^ 111 -> 010

        start = System.nanoTime();
        long xor = 1;
        while (xor <= num) {
            xor = xor * 2;
        }
        xor = xor - 1;
        System.out.println("xor time : " + (System.nanoTime() - start));
        System.out.println("xor1: " + (num ^ (int)xor));
        /*
        System.out.println("sqrt: " + Math.sqrt(num)); // 32 -> 46340
        System.out.println("pow: " + Math.pow(2, (int)(Math.sqrt(num) + 1))); // 2^3 - 1 222
        long pow = (long)Math.pow(2, (int)(Math.sqrt(num) + 1)); // 3^2 - 1
        long result = num ^ (int)(pow - 1); // (3^2 - 1)  8 - 1 =  3493 > 2 ^ N <-
        System.out.println("xor2: " + result); // 1 , 2147483647
        */

        // num >> 1
        start = System.nanoTime();
        int result = 0;
        for (int c = 0; num != 0; c++) {
            //1101
            int x = num & 1;
            if (x == 0) {
                result += (1 << c);
            }
            num = num >> 1;
        }
        System.out.println("shift time : " + (System.nanoTime() - start));
        System.out.println("shift : " + result);

        return num;
    }
    public static void main(String[] args) throws Exception {
        Solution1227 s = new Solution1227();

        System.out.println(s.findComplement(5)); // 2
        System.out.println("##################################");
        System.out.println(s.findComplement(1)); // 0
        System.out.println("##################################");
        System.out.println(s.findComplement(2147483647));
        System.out.println(s.findComplement(23423432));
        System.out.println(s.findComplement(2344234));
        System.out.println(s.findComplement(99992341));
        System.out.println(s.findComplement(939039939));
    }
}
