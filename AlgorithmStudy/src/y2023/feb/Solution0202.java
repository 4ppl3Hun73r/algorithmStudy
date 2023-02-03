package y2023.feb;

// https://leetcode.com/problems/verifying-an-alien-dictionary/
public class Solution0202 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        int index = 0;

        for (char c : order.toCharArray()) {
            orderMap[c - 'a'] = index++;
        }

        // compare words[0] , words[1]
        for (int i = 0; i < words.length - 1; i++) {
            if (compareValues(words[i], words[i + 1], words[i].length(), words[i + 1].length(), orderMap) > 0) {
                return false;
            }
        }

        return true;
    }

    // StringUTF16.java 에서 가져왔습니다.
    private int compareValues(String value, String other, int len1, int len2, int[] orderMap) {
        char[] ch1 = value.toCharArray();
        char[] ch2 = other.toCharArray();

        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            int c1 = orderMap[ch1[k] - 'a'];
            int c2 = orderMap[ch2[k] - 'a'];
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        return len1 - len2;
    }
}
