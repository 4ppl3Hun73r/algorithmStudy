package y2022.jul;

import model.ListCodec;
import model.ListNode;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class Solution0721 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*

        left <= right 뒤집기

        left = 2, right 4 (1 index, pos)
        1,2,3,4,5
          ^   ^
        1,4,3,2,5

          N-> 1 -> 2 -> 3 -> 4 ->

     idx  0   1    2 <- 3    4    5
                   ^
     idx  0   1    2 <- 3
                        3 <- 4
                             4 <-  1
                                    5 <- 1
            // leftBeforeNode = 1;
            // temp = 2
     rev  f   f    t
                   P    T
                             N
                     <-
                        P
                             T
              LB           ->T
                   L            ->
         1, 5 알아야함

          */
        if (left == right) {
            return head;
        }

        ListNode newHead = new ListNode(-1, head);
        ListNode temp = newHead;
        ListNode prev = newHead;
        ListNode next;
        int idx = 0;
        boolean reverse = false;
        ListNode leftNode = null;
        ListNode leftBeforeNode = null;
        while (temp != null) {
            if (idx == right) {
                leftBeforeNode.next = temp;
                leftNode.next = temp.next;
                temp.next = prev;
                break;
            }
            if (reverse) {
                next = temp.next;
                temp.next = prev;

                prev = temp;
                temp = next;
                idx++;
                continue;
            }
            if (idx == left) {
                reverse = true;
                leftBeforeNode = prev;
                leftNode = temp;
            }

            prev = temp;
            temp = temp.next;
            idx++;

        }

        return newHead.next;
    }

    public static void main(String[] args) throws Exception {
        Solution0721 s = new Solution0721();

        ListCodec l = new ListCodec();

        System.out.println(s.reverseBetween(l.deserialize("1,2,3,4,5"), 2, 4));
        System.out.println(s.reverseBetween(l.deserialize("1,2,3,4,5"), 1, 5));
    }
}
