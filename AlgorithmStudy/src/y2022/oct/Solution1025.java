package y2022.oct;

// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class Solution1025 {
    //안녕하세요
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

}
