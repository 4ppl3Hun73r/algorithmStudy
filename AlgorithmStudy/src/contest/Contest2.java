package contest;

import model.ListNode;

public class Contest2 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.next;
        }

        node = head;
        for (int i = 0; i < (cnt / 2) - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;


        return head;
    }


    public static void main(String[] args) {
        Contest2 c = new Contest2();
    }
}
