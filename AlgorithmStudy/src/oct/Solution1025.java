package oct;


// https://leetcode.com/problems/min-stack/
public class Solution1025 {
    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("-3 : " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("0 : " + minStack.top()); // 0
        System.out.println("-2 : " + minStack.getMin()); // -2
    }
}

class MinStack {
    Node head = null;
    /*
       5    -> min -3
       4
       -3
       0
       -2
       (5, -3)
       (4, -3)
       (-3, -3)
       (0, -2)
       (-2, -2)
     */

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(head.min, val), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        // O(N) -> stack을 다 확인함 ->
        return head.min;
    }

    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */