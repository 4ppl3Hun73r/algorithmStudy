package y2022.oct;

import model.ListNode;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class Solution1013 {

    public void deleteNode(ListNode node) {
        ListNode before = null;
        while (node.next != null) {
            node.val = node.next.val;
            before = node;
            node = node.next;
        }
        before.next = null;
    }
}
