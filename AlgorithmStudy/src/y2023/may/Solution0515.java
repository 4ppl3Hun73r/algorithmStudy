package y2023.may;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class Solution0515 {
    public ListNode swapNodes(ListNode head, int k) {
        /*
         앞에서 k 번째랑 뒤에서 k 번째의 값을 바꾸기
         뒤에서 K 를 얼마나 효율적으로 찾을 것인가?
         */

        // count => O(N) // <order, node> => 공간이랑 쓸일인가?
        // k / cnt - k

        List<ListNode> nodes = new ArrayList<>();
        ListNode start = head;
        while (start != null) {
            nodes.add(start);
            start = start.next;
        }

        ListNode a = nodes.get(k - 1);
        ListNode b = nodes.get(nodes.size() - k);
        int t = a.val;
        a.val = b.val;
        b.val = t;

        return head;
    }

    public ListNode swapNodes1st(ListNode head, int k) {
        ListNode temp = head;
        ListNode rtemp = head;
        ListNode ctemp = head;
        int cnt = 1;
        while(cnt<k){
            rtemp = rtemp.next;  // 역방향 K
            ctemp = ctemp.next;  // 정방향 K
            cnt++;
        }
        /*
          1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7, k = 2
               ^                   ^
        c      c
        r      r
                                   tN
                                        r
         O(k) + O(n - K) => O(N)

         // cnt => O(N)
         // O(k) => O(N + k) 4ms


        front <- cache layer(?) -> graphql(server) < grpc -> msa components (조회는 원작적으로 하든, join 으로 하든 상관 없음)

        zipkin, **pinpoint** webflux 지원 안해줬는데 해줘서....
        open tracing -> open 소스 표준, 이걸 구현 하는게 zipkin, 예거, pinpoint, ...
        traefik **istio**
         */

        while(rtemp.next != null) {
            temp = temp.next;
            rtemp = rtemp.next;
        }
        int d = temp.val;
        temp.val = ctemp.val;
        ctemp.val = d;
        return head;

    }
}
