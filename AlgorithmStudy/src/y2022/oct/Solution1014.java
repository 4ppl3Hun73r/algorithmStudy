package y2022.oct;

import model.ListCodec;
import model.ListNode;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class Solution1014 {
    public ListNode deleteMiddle(ListNode head) {
        // 가운데를 찾아야 한다. N -> 2/N
        //
        if (head.next == null) {
            return null;
        }

        ListNode before = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            before = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //System.out.println(slow.val);
        before.next = slow.next;
        // slow -> middle -> slow before

        return head;
    }

    public static void main(String[] args) throws Exception {
        Solution1014 s = new Solution1014();

        ListCodec l = new ListCodec();

        System.out.println(s.deleteMiddle(l.deserialize("1")));
        System.out.println(s.deleteMiddle(l.deserialize("1,2")));
    }
}
