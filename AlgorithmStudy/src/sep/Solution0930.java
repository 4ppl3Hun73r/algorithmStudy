package sep;

import model.ListNode;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3992/
public class Solution0930 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] results = new ListNode[k];

        // linklist -> k개의 파트로 쪼개기
        // 1 -> 2 -> 3 -> 4, 5
        // [[1], [3], [4], [], []]
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int part = count / k; // k
        int remain = count % k;
        ListNode start = head;
        int partCnt = 0;
        int resultIndex = 0;
        for (int i = 0; i < k; i++) {
            if (start == null) {
                results[i] = null;
                continue;
            }
            results[i] = start;
            ListNode prev = start;
            for(int j = 0 ; j < part + (remain > 0 ? 1 : 0) ; j++){
                prev = start;
                start = start.next;
            }
            prev.next = null;
            remain--;
        }

        return results;
    }
}
