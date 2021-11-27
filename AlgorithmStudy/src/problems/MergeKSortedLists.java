package problems;

import model.ListCodec;
import model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode head = new ListNode(0);

        ListNode node = head;
        boolean allNull = false;
        while(!allNull) {
            allNull = true;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    ListNode temp = lists[i];
                    lists[i] = lists[i].next;

                    temp.next = null;
                    priorityQueue.add(temp);
                    allNull = false;
                }
            }
            if (!priorityQueue.isEmpty()) {
                node.next = priorityQueue.poll();
                node = node.next;
            }
        }
        while (!priorityQueue.isEmpty()) {
            node.next = priorityQueue.poll();
            node = node.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();
        ListCodec c = new ListCodec();
        //m.mergeKLists(new ListNode[]{c.deserialize("1,4,5"), c.deserialize("1,3,4"), c.deserialize("2,6")});
        m.mergeKLists(new ListNode[]{c.deserialize("1,2,2"), c.deserialize("1,1,2"), c.deserialize("2,6")});
    }
}
