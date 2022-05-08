package problems;

// https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
public class RemoveDigitFromNumberToMaximizeResult {

    public String removeDigit(String number, char digit) {
        for (int i = 0; i < number.length() - 1; i++) {
            char ch = number.charAt(i);
            if (ch == digit && number.charAt(i + 1) > digit) {
                return number.substring(0, i) + number.substring(i + 1);
            }
        }

        int last = number.lastIndexOf(digit);
        return number.substring(0, last) + number.substring(last + 1);
    }
    /*
    2

    2323232323

     */

}









