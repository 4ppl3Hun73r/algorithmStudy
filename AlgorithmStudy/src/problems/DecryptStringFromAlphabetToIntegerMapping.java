package problems;

// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class DecryptStringFromAlphabetToIntegerMapping {

    public String freqAlphabets(String s) {
        /*
        1 -> a
        2 -> b
        9 -> i

        10# -> j
        26# -> z
         */

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2) {
                if (s.charAt(i + 2) == '#') {
                    int idx = s.charAt(i) - '0';
                    idx = idx * 10;
                    idx += s.charAt(i + 1) - '0';
                    sb.append((char)('a' + idx - 1));
                    i+=2;
                    continue;
                }
            }
            sb.append((char)('a' + (s.charAt(i) - '0') - 1));
        }

        return sb.toString();
    }

}
