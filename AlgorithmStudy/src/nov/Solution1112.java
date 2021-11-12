package nov;

import model.ListNode;

// https://leetcode.com/problems/remove-linked-list-elements/
public class Solution1112 {
    public ListNode removeElements(ListNode head, int val) {
        // listNode 에서 val 삭제
        ListNode newHead = new ListNode(-1, head);
        ListNode node = newHead;
        while(node != null) {  // O(N)
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }

        return newHead.next;
    }
}
