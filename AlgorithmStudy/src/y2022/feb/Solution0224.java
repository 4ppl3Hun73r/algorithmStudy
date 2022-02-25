package y2022.feb;

import model.ListNode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-list/
public class Solution0224 {
    public ListNode sortList(ListNode head) {
        /*
        O(n logn), O(1) memory solve?
        https://www.educative.io/edpresso/nlogn-sorting-algorithms
        Merge Sort, HeapSort, Quick Sort
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        /*int[] a = new int[50000];
        Arrays.sort(a, 0, 100);*/
        ListNode temp = head;
        while (temp != null) {
            queue.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (!queue.isEmpty()) {
            temp.val = queue.poll();
            temp = temp.next;
        }

        return head;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        /*
         1 -> 2 -> 3 -> 4
         1 -> 2 -> null
         3(mid) -> 4 -> null
         */
        ListNode mid = getMid(head);
        ListNode left = sortList2(head);
        ListNode right = sortList2(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            /*
            원본이 : 4, 3, 2, 1
            list1 : 4
            list2 : 3

            list1 : 3, 4
            list2 : 1, 2

            tail -> 1 -> 2 -> 3 -> 4
             */
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        /*
        fast, slow
        head : fast
        midPrev : slow
         */
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
