package y2022.mar;

import java.util.Stack;

// https://leetcode.com/problems/validate-stack-sequences/
public class Solution0316 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // popped 를 보고 valid하게 pushed 된건지 확인
        int len = pushed.length;


        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            int push = pushed[i];
            stack.push(push);

            while (!stack.isEmpty() && j < len && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }

        return j == len;
    }
}
