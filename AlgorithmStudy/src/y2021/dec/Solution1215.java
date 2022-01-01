package y2021.dec;

import model.ListCodec;
import model.ListNode;

// https://leetcode.com/problems/insertion-sort-list/submissions/
public class Solution1215 {
    public ListNode insertionSortList(ListNode head) {
        // N -> 4 -> 2 -> 3 -> 1
        // p    c    n
        // p    n    c
        //      n    c         p
        //    (c,n)
        // N -> 2 -> 4 -> 3 -> 1 <--
        // N -> 2 -> 3 -> 4 -> 1
        // N -> 1 -> 2 -> 3 -> 4
        // insert sort -> N^2 -> time complex
        ListNode newHead = new ListNode(-5001);
        ListNode prev = newHead;
        ListNode curr = head;
        // One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
        while (curr != null) {
            ListNode next = curr.next;
            // 2 -> 4
            // p                             4             3
            while (prev.next != null && prev.next.val < curr.val) {
                // p - .ne
                prev = prev.next;
            }
            // insertion
            // c : 3
            // 2 -> 4
            // p
            // 2 -> 4 -> 3
            // n
            curr.next = prev.next; // 3 -> ?? => 3 -> 4
            prev.next = curr; // 2 -> 3 -> 4
            // 4 -> 2 -> 3
            // insert 하는 구간이 정렬이 되어 있다는 보장 이 있어야 한다.
            // 4 -> 2 -> 1 -> 3 // 어디까지 정렬이 되어 있는지 모르는 상태
            // 정렬되는 링크드 리스트가 따로 존재
            // SortedLinkedList ->
            // newHead :
            //    p
            // head : 4 -> 2 -> 1 -> 3
			/*
			newHead -> 4
			head - 2 -> 1 -> 3
			newHead -> 2 -> 4
			head 1 -> 3
			 */
            // 탐색 위치 정리
            curr = next;
            prev = newHead;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListCodec c = new ListCodec();
        Solution1215 s = new Solution1215();
        System.out.println(s.insertionSortList(c.deserialize("4,2,3,1")));
        System.out.println(s.insertionSortList(c.deserialize("-1,5,3,4,0")));
        System.out.println(s.insertionSortList(c.deserialize("1"))); // bbbb
        System.out.println(s.insertionSortList(c.deserialize("3,2,3,4,35,23,32,42,35,2,2,34,2,432,-99,23,42,4,2,52,42,4,24")));
    }

}
// 되나요?
// 소리는 안들려요
// 안들려요? 전 들리는데.. 네
// 안들려요. ㅎㅎ
// 제 목소리는 들리시나요? 네
// 다시 파보시면 안될까요