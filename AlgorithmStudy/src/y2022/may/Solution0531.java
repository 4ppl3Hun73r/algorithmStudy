package y2022.may;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
public class Solution0531 {

    public boolean hasAllCodes(String s, int k) {
        /*
        k 길이의 바이너리 코드가 s에 속해 있는지 확인
        k == 2 -> 00, 01, 10, 11
        k = 20, 2^20
        s == 00110110 ->
             00
              01
                10
               11
               //500000
        set = 00, 01, 11, 10, --> len 4 == 2^k true? false?
        substring? ??? -> 시간초과
        char[] -> window?
        int bit -> int << 1 s.getChar <<

      S 0011011011
      W 00000000110
      M 00000000011
                 10 -> set
        00000000111
        ----------
        0011


        "00110"
        2

        우리값은 : false

         */
        if (s.length() < k) {
            return false;
        }

        int mask = (1 << k) - 1;
        int window = 0;

        for (int i = 0; i < k; i++) {
            window = window << 1;
            window = window | s.charAt(i) - '0';
            //System.out.println(Integer.toBinaryString(window));
        }

        Set<Integer> set = new HashSet<>();
        set.add(window);
        for (int i = k; i < s.length(); i++) {
            window = window << 1;

            window = window | (s.charAt(i) - '0'); // '0' , '1' '0' -'0' == 0, '1' - '0' = 1
            window = window & mask;
            set.add(window);
        }

        System.out.println(set);
        return set.size() == Math.pow(2, k);
    }

    public static void main(String[] args) throws Exception {
        Solution0531 s = new Solution0531();

        //System.out.println(s.hasAllCodes("1010010101010101010010101001101010", 20));
        System.out.println(s.hasAllCodes("00110", 2));
    }
}
