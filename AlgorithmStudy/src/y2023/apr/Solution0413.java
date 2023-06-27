package y2023.apr;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/validate-stack-sequences/
public class Solution0413 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // push [1,2,3,4,5]
        // pop  [4,5,3,2,1]
        // stack = []
        // [1,2,3,4,5]
        // [4,,53,1,2]
        // [1,2]

//        Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
}
