package problems;

import model.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(-1, head);
        ListNode before = newHead;
        ListNode node = before.next;
        while (node != null) {
            stack.push(node);
            node = node.next;
            if (stack.size() == k) {
                while(!stack.isEmpty()) {
                    before.next = stack.pop();
                    before.next.next = null;
                    before = before.next;
                }
            }
        }

        if (!stack.isEmpty()) {
            before.next = stack.get(0);
        }


        return newHead.next;
    }
}
