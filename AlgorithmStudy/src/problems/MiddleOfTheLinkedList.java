package problems;

import model.ListNode;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }

        // 2 -> 2
        // 6 -> 4
        // 3 -> 2
        // 5 -> 3

        count = (count / 2) + 1;

        node = head;
        for (int i = 1; i < count; i++) {
            node = node.next;
        }

        return node;
    }
}
