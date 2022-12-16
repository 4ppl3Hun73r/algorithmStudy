package y2022.dec;

import java.util.Set;

// https://leetcode.com/problems/determine-if-string-halves-are-alike/
public class Solution1201 {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] arr = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (vowel.contains(arr[i])) {
                cnt++;
            }
        }

        for(int i = arr.length / 2; i < arr.length ; i++) {
            if (vowel.contains(arr[i])) {
                cnt--;
            }
        }

        return cnt == 0;
    }
}
