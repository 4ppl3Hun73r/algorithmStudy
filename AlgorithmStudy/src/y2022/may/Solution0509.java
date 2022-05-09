package y2022.may;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class Solution0509 {
    public List<String> letterCombinations(String digits) {
        /*
        1
        2 abc
        3 def
        4 ghi
        5 jkl
        6 mno
        7 pqrs
        8 tuv
        9 wxyz
        0
         */
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        char[][] phone = new char[][]{
                {},
                {},{'a','b','c'},{'d','e','f'},
                {'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
        };
        List<String> ans = new ArrayList<>();
        combination(new StringBuilder(), phone, digits, 0, ans);

        return ans;
    }

    private void combination(StringBuilder sb, char[][] phone, String digits, int step, List<String> ans){
        if(step >= digits.length()){
            ans.add(sb.toString());
            return ;
        }

        int digit = Character.getNumericValue(digits.charAt(step));
        for (int i = 0; i < phone[digit].length; i++) {
            sb.append(phone[digit][i]);
            combination(sb, phone, digits, step + 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        Solution0509 s = new Solution0509();

        System.out.println(s.letterCombinations("22"));
    }
}
