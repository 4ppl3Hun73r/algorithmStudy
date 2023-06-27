package y2023.mar;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class Solution0303 {
    public int strStr(String haystack, String needle) {

        loop:for (int i = 0; i < haystack.length(); i++) {
            char h = haystack.charAt(i);
            if (h == needle.charAt(0)) {
                for(int j = 0; j < needle.length(); j++) {
                    if ((j + i) >= haystack.length()) {
                        continue loop;
                    }
                    if (needle.charAt(j) != haystack.charAt(j+i)) {
                        continue loop;
                    }
                }
                return i;
            }
        }

        //"mississippi"
        //  issip
        //      issip
        // a a a b a c d, a b c
        //         a b c
        "".indexOf("");

        return -1;
    }

    public static void main(String[] args) throws Exception {
        Solution0303 s = new Solution0303();

        System.out.println(s.strStr("mississippi", "issip"));
    }
}
