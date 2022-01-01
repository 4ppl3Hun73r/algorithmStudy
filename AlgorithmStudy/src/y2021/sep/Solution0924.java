package y2021.sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3985/
public class Solution0924 {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 1) return "";

        char[] newPalindrome = palindrome.toCharArray();
        boolean change = false;
        for (int i = 0; i < len / 2; i++) {
            char ch = palindrome.charAt(i);
            if (ch != 'a') {
                newPalindrome[i] = 'a';
                change = true;
                break;
            }
        }

        if (change == false) {
            newPalindrome[len - 1] = 'b';
        }

        return new String(newPalindrome);
    }
    /*
     aaaaa -> aaaab
     abcba -> aacba
     aba -> abb

     */


    public static void main(String[] args) {
        Solution0924 s = new Solution0924();

        System.out.println(s.breakPalindrome("abccba"));
        System.out.println(s.breakPalindrome("a"));
        System.out.println(s.breakPalindrome("abcba"));


    }
}
