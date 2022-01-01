package y2021.dec;

import model.ListNode;

// https://leetcode.com/problems/odd-even-linked-list/
public class Solution1202 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode();
        ListNode node = head;
        ListNode next = node.next;
        temp.next = next;
        while (next != null) {
            node.next = next.next;
            if (node.next != null) {
                next.next = next.next.next;
            }
            if (node.next != null) {
                node = node.next;
            }
            next = next.next;
        }
        node.next = temp.next;
        return head;

    }
}
