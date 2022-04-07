package y2022.apr;

import model.ListNode;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list
public class Solution0404 {
    public ListNode swapNodes(ListNode head, int k) {

        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }

        ListNode a = null;
        ListNode b = null;
        int aIdx = k - 1;
        int bIdx = cnt - k;
        temp = head;
        for (int i = 0; i < cnt; i++) {
            if (i == aIdx) {
                a = temp;
            }
            if (i == bIdx) {
                b = temp;
            }
            temp = temp.next;
        }

        int t = a.val;
        a.val = b.val;
        b.val = t;

        return head;

    }
}
