package y2022.sep;

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class Solution0922 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                right = i - 1;

                for (int j = right; j >= left; j--) {
                    sb.append(arr[j]);
                }
                sb.append(' ');
                left = i + 1;
            }
        }

        for (int i = arr.length - 1; i >= left ; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public String reverseWordsSB(String s) {
        /*
        word 단위로 뒤집기

         */

        StringBuilder ans = new StringBuilder();
        StringBuilder rev = new StringBuilder();

        String[] split = s.split(" ");
        for (String s1 : split) {
            rev.append(s1);
            rev.reverse();
            ans.append(rev);
            ans.append(' ');
            rev.setLength(0);
        }
        return ans.substring(0, ans.length() - 1);
    }
}
