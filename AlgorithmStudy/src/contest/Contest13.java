package contest;

public class Contest13 {

    public String firstPalindrome(String[] words) {

        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }


    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

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

    public static void main(String[] args) {
        Contest13 c = new Contest13();
    }
}
