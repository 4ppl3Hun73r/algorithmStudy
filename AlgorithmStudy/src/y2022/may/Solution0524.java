package y2022.may;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/
public class Solution0524 {
    public int longestValidParentheses(String s) {
        /*
        ()()()() -> 8
        ((())) -> 6
        ))))))()(((( -> 2

         */


        /**
         * ()(((()((((
         *
         * stack is empty, ) -> valid X
         * ((()())  ()
         *  ------  --
         *
         * stack ((
         * list    1 1
         */

        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int start = stack.pop();
                    int end = i;
                    map.put(start, end);
                }
            }
        }

        for (int start = 0; start < s.length(); start++) {
            int subLen = 0;
            while (map.containsKey(start)) {
                int end = map.get(start);
                subLen += (end - start) + 1;

                start = end + 1;
            }
            ans = Math.max(ans, subLen);
        }

        // System.out.println(s);
        // System.out.println(stack);
        // System.out.println(map);
        // O(1) ->
        /*
        dp[i] = dp[i - 1] + f(i) or Math.max(dp[i - 1] + 1, dp[i - 2])
        4!
        5! = 4! * 5
         */

        return ans;
        /**
         * //s:0, s:7
         * s:1, e: 6
         * s:2, e: 3
         * s:4, e: 5
         *
         *
         * (()()()())(()()()())
         * (){}[]
         * !(s>max)
         */
    }

    public static void main(String[] args) throws Exception {
        Solution0524 s = new Solution0524();

        System.out.println(s.longestValidParentheses("()(((()(((("));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses("((()())()"));
    }
}
