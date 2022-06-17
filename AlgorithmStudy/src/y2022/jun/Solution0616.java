package y2022.jun;

// https://leetcode.com/problems/longest-palindromic-substring/
public class Solution0616 {

    int loop = 0;
    public String longestPalindrome(String s) {
        // 가장 긴 회문을 반환


        /*
            for loop

            111
            1111

            1 2 3 2 1
                    ^
         */

        int begin = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = checkPalindrome(s, i, i);
            if (len > max) {
                begin = i - (len / 2);
                end = i + (len / 2);
                max = len;
            }
            len = checkPalindrome(s, i, i+1);
            if (len > max) {
                begin = i - ((len - 1) / 2);
                end = i + (len / 2);
                max = len;
            }
        }

        //System.out.println(begin);
        //System.out.println(end);
        System.out.println(loop);
        return s.substring(begin, end + 1);
    }
    ///babad
    //cbbd
    //

    private int checkPalindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            loop++;
        }
        //System.out.println(start+" / "+end +" : "+(end-start));

        // 4 1 2 1 5
        // ^       ^ : +> -2
        // 0 base + 1
        return end - start - 2 + 1; // -2 인덱스 보정 +1은 zero base -> 길이로 환산
    }

    public static void main(String[] args) throws Exception {
        Solution0616 s = new Solution0616();

        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));

        System.out.println(s.longestPalindrome("cbbdslaifjlisajfihaiaaaaaaaaaaaaaaaaaaaaaaaaahilfadhslifhlaisdfhld"));
        System.out.println(s.longestPalindrome("cbbdslaifjlisajfihaiaaaaaaaaaaaaaaaaaaaaaaaaaahilfadhslifhlaisdfhld"));

        /*
        loop
        10
        6
        2145
        2211

        7
        12
        380
        774
         */
    }
    

}
