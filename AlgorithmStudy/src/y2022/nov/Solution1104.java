package y2022.nov;

// https://leetcode.com/problems/reverse-vowels-of-a-string/
public class Solution1104 {

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;


        char[] sArr = s.toCharArray();

        while (left < right) {
            char l = sArr[left];
            if (!isVowels(l)) {
                left++;
                continue;
            }
            char r = sArr[right];
            if (!isVowels(r)) {
                right--;
                continue;
            }

            char temp = l;
            sArr[left] = sArr[right];
            sArr[right] = temp;

            left++;
            right--;
        }

        return new String(sArr);

    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}
