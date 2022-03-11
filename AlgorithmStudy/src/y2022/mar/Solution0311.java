package y2022.mar;

import model.ListNode;

// https://leetcode.com/problems/rotate-list/
public class Solution0311 {

    public ListNode rotateRight(ListNode head, int k) {
        /*
        Input: head = [1,2,3,4,5], k = 2
        Output: [4,5,1,2,3]

        Input: head = [0,1,2], k = 4
        Output: [2,0,1]

        K번 로테이트시 내가 알아야 할것
        Size - k 번째 Node의 포인터와 그 전 Node의 포인터
        시작 Node의 포인터
        마지막 Node의 포인터

        0 <= k <= 2 * 109
        [0, 500]

        Size == 3 일때 K == 3 이면 원본으로 돌아옴
         */
        if (head == null) {
            return head;
        }

        int cnt = 0;
        ListNode temp = head;
        ListNode last = temp;
        while (temp != null) {
            last = temp;
            temp = temp.next;
            cnt++;
        }

        k = k % cnt;
        if (k == 0) {
            return head;
        }

        ListNode prev = null;
        temp = head;
        for (int i = 0; i < cnt - k; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        last.next = head;

        return temp;
    }
}
