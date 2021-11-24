package problems;

import model.ListNode;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();


        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            stack.push(node);
            node = node.next;
        }
        int k = count / 2;
        node = head;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            node.next = stack.pop();
            node.next.next = next;

            node = next;
        }
        node.next = null;

    }
}
