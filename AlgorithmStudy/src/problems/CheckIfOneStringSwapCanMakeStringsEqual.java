package problems;

// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int diff = 0;
        char[] s1Diff = new char[2];
        char[] s2Diff = new char[2];
        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                if (diff == 2) {
                    return false;
                }
                s1Diff[diff] = c1;
                s2Diff[diff] = c2;
                diff++;
            }
        }

        if (diff == 0) {
            return true;
        }

        return s1Diff[0] == s2Diff[1] && s1Diff[1] == s2Diff[0];
    }
}
