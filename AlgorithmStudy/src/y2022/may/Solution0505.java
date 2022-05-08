package y2022.may;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/
public class Solution0505 {
}

class MyStack {

    Queue<Integer> queue1;

    public MyStack() {
        queue1 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        int size = queue1.size();
        while (size > 1) {
            queue1.offer(queue1.remove());
            size--;
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}