package problems;

import model.ListCodec;
import model.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode removeNth = head;
        ListNode goLast = head;

        for (int i = 0; i < n; i++) {
            goLast = goLast.next;
        }
        if (goLast == null) {
            return head.next;
        }

        while (goLast.next != null) {
            removeNth = removeNth.next;
            goLast = goLast.next;
        }

        removeNth.next = removeNth.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListCodec codec = new ListCodec();

        System.out.println(r.removeNthFromEnd(codec.deserialize("1,2,3,4,5"), 2));
        System.out.println(r.removeNthFromEnd(codec.deserialize("1"), 1));
        System.out.println(r.removeNthFromEnd(codec.deserialize("1,2"), 1));
        System.out.println(r.removeNthFromEnd(codec.deserialize("1,2,3,4,5"), 5));
        System.out.println(r.removeNthFromEnd(codec.deserialize("1,2,3,4,5"), 1));

        /*
        [1,2,3,5]
        []
        [1]
        [2,3,4,5]
        [1,2,3,4]
         */
    }

}
