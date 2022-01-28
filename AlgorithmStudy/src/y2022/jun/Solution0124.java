package y2022.jun;

// https://leetcode.com/problems/detect-capital/
public class Solution0124 {
    /**
     * Runtime: 2 ms
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        /*
        1. 완전 대문자 > "USA"
        2. 완전 소문자 > "leetcode"
        3. 첫 글자만 대문자 > "Leetcode"
         */
        int cntUpperChar = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                cntUpperChar++;
            }
        }

        if (Character.isUpperCase(word.charAt(0))
                && (cntUpperChar == 1 || cntUpperChar == word.length())) {
            return true;
        } else if (cntUpperChar == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * regex => Runtime: 18 ms, faster than 5.09%
     * @param word
     * @return
     */
    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z][a-z]+|[A-Z]+|[a-z]+");
    }

}
