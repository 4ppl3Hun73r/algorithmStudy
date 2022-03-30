package problems;

// https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = Integer.toString(x);

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
