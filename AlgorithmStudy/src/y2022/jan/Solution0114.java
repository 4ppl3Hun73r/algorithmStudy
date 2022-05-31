package y2022.jan;

// https://leetcode.com/problems/string-to-integer-atoi/
public class Solution0114 {
    public int myAtoi(String s) {
        /*
        "42"
        "   -42" -> -42
        "4193 with words" - > 4193

        "42"                42
        "-42 words"         -42
        "...42"             0
        "...42..42"         0
        "+421-12"           421
        "-12313+12"         -12313
        "      24 word"     24
        "00000024 word"     24
        '-' '+' '[0-9]' ' '
         */
        long result = 0;
        int i = 0;
        int sign = 1;
        // 공백 제거
        for(; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                break;
            }
        }
        if (i >= s.length()) {
            return 0;
        }

        char ch = s.charAt(i);
        if (ch == '-') {
            sign = -1;
            i++;
        } else if (ch == '+') {
            i++;
        }

        for(; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            result = result * 10 + (ch - '0');

            if (result > Integer.MAX_VALUE) {
                break;
            }
        }
        // "9223372036854775808"

        result = result * sign;
        if (result >= Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }

        if (result <= Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return (int)result;
    }
}
