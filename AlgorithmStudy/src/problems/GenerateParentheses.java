package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generate(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void generate(List<String> result, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            generate(result, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            generate(result, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}

// n : 3, "((()))","(()())","(())()","()(())","()()()"
// n : 2, "()()", "(())"
// n : 1, "()"
