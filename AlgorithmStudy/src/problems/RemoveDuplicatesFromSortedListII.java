package problems;

import model.ListCodec;
import model.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // head 처리
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                head = head.next.next;
            }
        }
        if (head == null) {

        }


        ListNode node = head;
        ListNode nextNode = node.next;
        while (nextNode != null) {
            if (node.val == nextNode.val) {
                node.next = nextNode.next;
            } else {
                node = node.next;
            }
            nextNode = nextNode.next;
        }

        return head;
    }

    public static void main(String[] args) throws Exception {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListCodec c = new ListCodec();
        System.out.println(r.deleteDuplicates(c.deserialize("[1,2,3,3,4,4,5]")));
    }
}
