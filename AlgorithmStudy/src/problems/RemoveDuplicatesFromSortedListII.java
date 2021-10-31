package problems;

import model.ListCodec;
import model.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // node가 중복인가?
        // node 랑 node.next 랑 비교 해서 같으면 중복
        // node랑 node.next가 같지 안흘때까지 넘기기
        // 자기 앞 노드의 next를 위에 있는 node.nextfh

        ListNode result = new ListNode(0, head);

        ListNode node = result;
        ListNode nextNode = result.next;
        while (nextNode != null) {
            if (nextNode.next != null && nextNode.val == nextNode.next.val) {
                while (nextNode.next != null && nextNode.val == nextNode.next.val) {
                    nextNode = nextNode.next;
                }
                node.next = nextNode.next;
            } else {
                node = node.next;
            }
            nextNode = nextNode.next;
        }

        return result.next;
    }


    public static void main(String[] args) throws Exception {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListCodec c = new ListCodec();
        System.out.println(r.deleteDuplicates(c.deserialize("[1,2,3,3,4,4,5]")));
    }
}
