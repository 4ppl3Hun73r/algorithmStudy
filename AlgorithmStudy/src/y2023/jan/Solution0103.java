package y2023.jan;

// https://leetcode.com/problems/delete-columns-to-make-sorted/
public class Solution0103 {
    public int minDeletionSize(String[] strs) {
        // zyx
        // wvu
        // tsr

        int row = strs.length;
        int col = strs[0].length();
        int result = 0;

        for (int i = 0; i < col; i++) {
            int ch = 0;

            for (String str : strs) {
                if (str.charAt(i) < ch) {
                    result++;
                    break;
                }
                ch = str.charAt(i);
            }
        }
        return result;
    }
}
