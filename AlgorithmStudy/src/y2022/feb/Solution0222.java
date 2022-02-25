package y2022.feb;


// https://leetcode.com/problems/excel-sheet-column-number/
public class Solution0222 {
    public int titleToNumber(String columnTitle) {
        /*
        A : 1
        FXSHRXW : 2147483647

        26진수? 27진수? 0이 없어서 좀 애매....
         */
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0222 s = new Solution0222();
        System.out.println(s.titleToNumber("FXSHRXW"));
        System.out.println(s.titleToNumber("A"));
    }
}
