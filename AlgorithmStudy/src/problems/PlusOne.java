package problems;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            int subSum = digits[i] + carry;
            carry = subSum / 10;
            digits[i] = subSum % 10;
        }

        if (carry == 1) {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            for(int i = 1; i < len + 1; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }

        return digits;
    }
}
