package y2023.jan;

// https://leetcode.com/problems/detect-capital/
public class Solution0102 {
    public boolean detectCapitalUse(String word) {
        // 전부다 대문자, 전부다 소문자, 맨앞만 대문자 = true, 다른 케이스는 false

        int upperCnt = 0;
        for(char c :  word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCnt++;
            }
        }


        //word.matches("[A-Z]*|.[a-z]*");
        // 전부다 대문자 or 전부다 소문자 or 맨 앞만 대문자.
        return upperCnt == 0 || upperCnt == word.length() || (upperCnt == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
