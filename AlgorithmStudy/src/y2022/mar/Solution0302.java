package y2022.mar;

// https://leetcode.com/problems/is-subsequence/
public class Solution0302 {

    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean is = false;
            for (int j = start; j < t.length(); j++) {
                if (c == t.charAt(j)) {
                    start = j + 1;
                    is = true;
                    break;
                }
            }
            if (is == false) {
                return false;
            }
        }

        return true;
    }
}
