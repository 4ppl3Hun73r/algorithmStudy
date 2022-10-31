package y2022.oct;

// https://leetcode.com/problems/integer-to-roman/
public class Solution1020 {
    public String intToRoman(int num) {
        /*
            I : 1
            IV : 4
            V : 5
            IX : 9
            X : 10
            XL : 40
            L : 50
            XC : 90
            C : 100
            CD : 400
            D : 500
            CM : 900
            M : 1000
         */

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -=50;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            }else if (num >= 10) {
                sb.append("X");
                num -= 10;
            }else if (num >= 9) {
                sb.append("IX");
                num -= 9;
            }else if (num >= 5) {
                sb.append("V");
                num -= 5;
            }else if (num >= 4) {
                sb.append("IV");
                num -= 4;
            }else if (num >= 1) {
                sb.append("I");
                num -= 1;
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Solution1020 s = new Solution1020();

        System.out.println(s.intToRoman(1994));

        for (int i = 1; i < 3999; i++) {
            System.out.println(i);
            System.out.println(s.intToRoman(i));
        }
    }
}
