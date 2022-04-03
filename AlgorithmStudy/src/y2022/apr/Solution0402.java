package y2022.apr;

// https://leetcode.com/problems/valid-palindrome-ii/
public class Solution0402 {
    public boolean validPalindrome(String s) {
        return checkPalindrome(s, 0, s.length() - 1, 0);
    }

    private boolean checkPalindrome(String s, int left, int right, int delete) {
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) {
                if (delete == 0) {
                    return checkPalindrome(s, left + 1, right, 1) |
                            checkPalindrome(s, left, right - 1, 1);
                }
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0402 s = new Solution0402();

        System.out.println(s.validPalindrome("ebcbbececabbacecbbcbe")); // true
    }
}
