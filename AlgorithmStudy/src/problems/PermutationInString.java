package problems;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1 in s2
        int[] s1CharArr = new int[26];
        for (char c : s1.toCharArray()) {
            s1CharArr[c - 'a'] ++;
        }

        char[] s2CharArr = s2.toCharArray();
        int windowSize = s1.length();

        for (int i = 0; i < windowSize; i++) {
            s1CharArr[s2CharArr[i] - 'a'] --;
        }

        for (int i = 1; i <= s2.length() - windowSize; i++) {
            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if (s1CharArr[j] != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
            s1CharArr[s2CharArr[i - 1] - 'a'] ++;
            s1CharArr[s2CharArr[i + windowSize - 1] - 'a'] --;
        }

        boolean ok = true;
        for (int j = 0; j < 26; j++) {
            if (s1CharArr[j] != 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }

    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();

        System.out.println(p.checkInclusion("ab", "eidbaooo")); //  true
        System.out.println(p.checkInclusion("ab", "eidboaooo")); // false
        System.out.println(p.checkInclusion("dboie", "eidboaooo")); // true
        System.out.println(p.checkInclusion("adc", "dcda")); // true
    }
}
