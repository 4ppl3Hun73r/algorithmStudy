package y2021.sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/
public class Solution0915 {

    public String reverseOnlyLetters(String s) {
        // c < 'A' || 'z' < c 틀린 조건 => Charater.isAlphabetic(c) // swap

        return s;
    }

    public String jiho(String s) {
        int start = 0;
        int last = s.length() - 1;
        char[] chars = s.toCharArray();

        while (start < last) {
            int sChar = chars[start];
            int lChar = chars[last];
            if (!Character.isLetter(sChar)) {
                start++;
                continue;
            }
            if (!(lChar >= 'a' && lChar <= 'z' || lChar >= 'A' && lChar <='Z')) {
                last--;
                continue;
            }

            char temp = chars[start];
            chars[start] = chars[last];
            chars[last] = temp;
            start++;
            last--;
        }

        return new String(chars);
    }

    public String jeonghwan(String s) {

        char[] chars = s.toCharArray();
        int i = 0;
        int j = (chars.length - 1);
        while (i < j) {
            char c1 = chars[i];
            if (!Character.isAlphabetic(c1)) {
                i++;
                continue;
            }

            char c2 = chars[j];
            if (!Character.isAlphabetic(c2)) {
                j--;
                continue;
            }

            chars[j--] = c1;
            chars[i++] = c2;
        }

        return new String(chars);
    }

    /*
    fun reverseOnlyLetters(s: String): String {
        val upperRange = 'A'..'Z'
        val lowerRange = 'a'..'z'

        val reversedAlphabet = s.toCharArray()
            .filter { it in upperRange || it in lowerRange }
            .reversed()
            .iterator()

        val builder = StringBuilder(s.length)

        for (c in s) {
            builder.append(
                when (c) {
                    in upperRange, in lowerRange -> reversedAlphabet.next()
                    else -> c
                }
            )
        }
        return builder.toString()
    }
     */

    public static void main(String[] args) {
        Solution0915 s = new Solution0915();
        System.out.println(s.reverseOnlyLetters("ab-cd"));
        // dc-ba
        System.out.println(s.reverseOnlyLetters("a-bC-dEf-ghIj"));
        // j-Ih-gfE-dCba
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        // Qedo1ct-eeLg=ntse-T!
    }
}

