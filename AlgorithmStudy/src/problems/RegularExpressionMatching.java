package problems;

import java.util.Stack;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }


        for (int i = p.length() - 1; i >= 0; i--) {
            /*
              ......*

              푸는중...
             */


        }

        return false;



    }
}
