package y2021.sep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3971/
public class Solution0912 {
    public int calculate(String s) {
        Queue<String> postfix = new LinkedList<>();
        Stack<String> temp = new Stack<>();

        if (s.trim().charAt(0) == '-') {
            s = "0" + s;
        }

        java.util.StringTokenizer st = new java.util.StringTokenizer(s, "()+- ", true);


        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.trim().length() == 0) continue;;
            try {
                Integer.parseInt(token);
                postfix.add(token);
            } catch (Exception e) {
                if (token.equals("(")) {
                    temp.push(token);
                } else if (token.equals(")")) {
                    String oper = null;
                    while (!(oper = temp.pop()).equals("(")) {
                        postfix.add(oper);
                    }
                } else {
                    while (!temp.isEmpty() && !temp.peek().equals("(")) {
                        postfix.add(temp.pop());
                    }
                    temp.push(token);
                }
            }
        }
        while (!temp.isEmpty()) {
            postfix.add(temp.pop());
        }

        System.out.println(postfix);

        String result = "";
        while(!postfix.isEmpty()) {
            String token = postfix.poll();
            if (!(token.equals("+") || token.equals("-"))) {
                temp.push(token);
            } else {
                int a = Integer.parseInt(temp.pop());
                int b = Integer.parseInt(temp.pop());
                String oper = token;
                if (oper.equals("+")) {
                    temp.push("" + (a + b));
                } else {
                    temp.push("" + (b - a));
                }
            }
        }

        return Integer.parseInt(temp.pop());
    }

    public static void main(String[] args) {
        Solution0912 s = new Solution0912();
        /*System.out.println(s.calculate("1 + 1"));
        System.out.println(s.calculate("(12 + 12 - (1 + 2))"));
        System.out.println(s.calculate(" 2-1 + 2 "));*/
        System.out.println(s.calculate("-2+ 1"));
    }
}
