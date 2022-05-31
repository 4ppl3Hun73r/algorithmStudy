package y2022.jan;

// https://leetcode.com/problems/add-binary/
public class Solution0110 {
    public String addBinary(String a, String b) {
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        // 1 <= a,b <= 10000

        int carry = 0;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int ai = 0;
            int bi = 0;
            if (aIndex >= 0) {
                ai = a.charAt(aIndex--) - '0';
            }
            if (bIndex >= 0) {
                bi = b.charAt(bIndex--) - '0';
            }
            int sum = ai + bi + carry;

            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        Solution0110 s = new Solution0110();
        System.out.println(s.addBinary("111", "111"));
        System.out.println(s.addBinary("111", "1"));
        System.out.println(s.addBinary("100000000000011", "1101010101"));
        System.out.println(s.addBinary("10", "111111111111111111111111111111"));
                                                // 1000000000000000000000000000001
    }

}
