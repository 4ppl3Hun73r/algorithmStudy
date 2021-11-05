package problems;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
}

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        moveStackValue();

        return stack2.pop();
    }

    public int peek() {
        moveStackValue();

        return stack2.peek();
    }

    private void moveStackValue() {
        if (stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}