package problems;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        char[] sArr = s.toCharArray();
        int left = 0;
        int right = sArr.length - 1;

        boolean result = false;
        while (left < right) {
            if (!Character.isAlphabetic(sArr[left])) {
                left++;
                continue;
            }
            if (!Character.isAlphabetic(sArr[right])) {
                right--;
                continue;
            }

            if (Character.toLowerCase(sArr[left]) != Character.toLowerCase(sArr[right])) {
                return false;
            }
            left++;
            right--;
            result = true;
        }

        return result;
    }
}
