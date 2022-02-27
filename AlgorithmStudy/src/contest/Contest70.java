package contest;

import model.ListNode;

public class Contest70 {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);

        ListNode node = head;
        ListNode temp = newHead;
        int sum = 0;
        while (node != null) {
            if (node.val == 0) {
                if (sum != 0) {
                    temp.next = new ListNode(sum);
                    temp = temp.next;
                }
                sum = 0;
            } else {
                sum += node.val;
            }
            node = node.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Contest70 c = new Contest70();

    }
}
