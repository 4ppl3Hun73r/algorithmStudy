package y2022.jun;

import model.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Solution0606 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = count(headA);
        int bLen = count(headB);

        if (aLen > bLen) {
            int diff = aLen - bLen;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            int diff = bLen - aLen;
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int count(ListNode node) {
        int cnt = 0;
        ListNode t = node;
        while(t != null) {
            t = t.next;
            cnt++;
        }
        return cnt;
    }
}
