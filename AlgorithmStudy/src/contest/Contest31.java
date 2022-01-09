package contest;

import java.util.HashMap;
import java.util.Map;

public class Contest31 {
    public int longestPalindrome(String[] words) {

        /*
        word.length = 2


        "ab","ty","yt","lc","cl","ab"
        ty lc cl yt
        lc ty yt cl
         */
        Map<String, Integer> palindromeMap = new HashMap<>();
        for (String word : words) {
            palindromeMap.put(word, palindromeMap.getOrDefault(word, 0) + 1);
        }

        int strLen = 0;
        boolean check = false;
        System.out.println(palindromeMap);
        for (String word : words) {
            if (!palindromeMap.containsKey(word)) {
                continue;
            }
            String reverse = "" + word.charAt(1) + word.charAt(0);

            if (word.charAt(0) == word.charAt(1)) {
                int cnt = palindromeMap.get(word);
                if (cnt == 1) {
                    if (!check) {
                        check = true;
                        strLen += 2;
                        palindromeMap.remove(word);
                    }
                } else {
                    cnt -= 2;
                    if (cnt == 0) {
                        palindromeMap.remove(word);
                    } else {
                        palindromeMap.put(word, cnt);
                    }
                    strLen += 4;
                }
            } else if (palindromeMap.containsKey(reverse)) {
                int cnt1 = palindromeMap.get(word);
                int cnt2 = palindromeMap.get(reverse);
                cnt1--;
                cnt2--;
                if (cnt1 == 0) {
                    palindromeMap.remove(word);
                } else {
                    palindromeMap.put(word, cnt1);
                }
                if (cnt2 == 0) {
                    palindromeMap.remove(reverse);
                } else {
                    palindromeMap.put(reverse, cnt2);
                }
                strLen += 4;
            }
        }
        return strLen;

    }

    public static void main(String[] args) {
        Contest31 c = new Contest31();

        // ["em","pe","mp","ee","pp","me","ep","em","em","me"] 14
        // 난 22 답 14

        System.out.println(c.longestPalindrome(new String[]{"em","pe","mp","ee","pp","me","ep","em","em","me"}));
    }
}
