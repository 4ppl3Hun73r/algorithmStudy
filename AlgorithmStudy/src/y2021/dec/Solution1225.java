package y2021.dec;

import java.util.Stack;

// https://leetcode.com/problems/basic-calculator-ii/
public class Solution1225 {
    public int calculate(String s) {
        // s 는 +, -, *, / 로
        // 숫자는 양수(0 포함)

        // 3 + 3 * 2 -> 3 + 6 -> 9
        // *, / 는 우선순위가 높게
        // 다른 부호는 흐음....
        Stack<Integer> valueStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        java.util.StringTokenizer st = new java.util.StringTokenizer(s, "+-*/", true);
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            String trimToken = token.trim();
            if (trimToken.length() == 0) continue;;
            try {
                int value = Integer.parseInt(trimToken);
                valueStack.add(value);
            } catch (Exception e) {
                // 입력에 오류가 없다고 보장 할수 있으므로 바로 검사를 할 수 있음
                if ("+".equals(trimToken) || "-".equals(trimToken)) {
                    // 바로 계산 못하니까 저장만 해 놓음
                    operStack.push(trimToken);
                } else { // *, /
                    // 바로 계산 하면 됨
                    int value1 = valueStack.pop();
                    int value2 = Integer.parseInt(st.nextToken().trim());
                    if ("*".equals(trimToken)) {
                        valueStack.push(value1 * value2);
                    } else {
                        valueStack.push(value1 / value2);
                    }
                }
            }
        }

        // 남는 value와 남는 oper 가지고 계산 -> 처음부터 계산 해야 하는데..... stack 뒤집기?
        //System.out.println(valueStack);
        //System.out.println(operStack);
        int idx = 1;
        for (String oper : operStack) {
            if ("+".equals(oper)) {
                valueStack.set(0, valueStack.get(0) + valueStack.get(idx++));
            } else {
                valueStack.set(0, valueStack.get(0) - valueStack.get(idx++));
            }
        }
        //System.out.println(valueStack);

        return valueStack.get(0);
    }

    public static void main(String[] args) {
        Solution1225 s = new Solution1225();
        System.out.println(s.calculate("3+3/4+2+4*12/3223/3*4+39+332+12-1291+3239")); // 2336
    }
}
