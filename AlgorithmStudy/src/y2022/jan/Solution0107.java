package y2022.jan;

import model.ListCodec;
import model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

// https://leetcode.com/problems/linked-list-random-node/
public class Solution0107 {
/*
동일 확률로 반환하는 랜덤
1 < node.length < 10000
-10000 <= val <= 10000

추가 공간을 안쓰고 해결할수 있는가?
 */

    public static void main(String[] args) throws Exception {
        ListCodec codec = new ListCodec();
        Solution ss = new Solution(codec.deserialize("10,1,10,20,100"));
        for (int i = 0; i < 100; i++) {
            System.out.print(ss.getRandomReservoirSampling());
        }
        System.out.println();
    }
}

class Solution {
    ListNode head;
    ListNode curr;
    Random random;
    PriorityQueue<ListNode> queue;
    List<ListNode> list;

    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
        queue = new PriorityQueue<>((a, b) -> random.nextInt());
        list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        makeQueue();
        // [1,2,3,4,5,7]
        // head
        // stack / queue -> scrable.... 필요
        // 우선순위 queue
    }

    public int getRandom2() {
        if (curr == null) {
            curr = head;
        }
        int val = curr.val;
        curr = curr.next;

        return val;
    }

    private void makeQueue() {
        ListNode node = this.head;
        while(node != null) {
            queue.add(node);
            node = node.next;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size())).val;
    }

    public int getRandomQueue() {
        if (queue.isEmpty()) {
            makeQueue();
        }

        return queue.poll().val;
    }

    public int getRandomReservoirSampling() {
        /*
        순차적으로 한 번에 하나의 샘플만 볼 수 있고
        전체 샘플 개수를 모르는 상황에서 무작위 추출을 하는 방법
         */
        int scope = 1, chosenValue = 0;
        ListNode curr = this.head;
        while (curr != null) {
            // decide whether to include the element in reservoir
            // Math.random -> 0.0 < double < 1.0
            // 당첨된에를 포인터가 있고 -> 4
            // 1 -> 무조건 당첨 1 / 1
            // 2 -> 1 / 2
            // 3 -> 1 / 3
            // 4 -> 1 / 4
            if (Math.random() < 1.0 / scope) // 1, 0.5, 0.3 ... (1/N)
                chosenValue = curr.val;
            // move on to the next node
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;
    }
    // 이벤트 설계 하는데 신청자가 10억 -> 1 / 10억 -> 알수가있는데
    // 이벤트 결과가 종료하고 1분 이내에 나와야 되요
    // 종료하자 -> 바로 담청자를 알려줄수 있음
    // nelo2 샘플링 할때 -> 들어오는 양을 모르는데, 샘플링 해서 저장해야 하자나요.
    // 정해진 시간마다 ms -> 저장할 메시지를 선택할때 사용할수 있겠네요.

    // https://ieeexplore.ieee.org/abstract/document/4274967

    /*
        1 -> 2 -> 3 -> 4 ...
        1/1 -> 1/2 -> 1/3 -> 1/4 ....
        0.1 -> 0.6 -> 0.7 -> 0. ....


        1 -> 100% -> **멀뽑든**(Math.random()) // 소름 bb
        2 -> 50% -> Math.random()
        3 -> 33% -> Math.random()
        4 -> 25% -> ...
        ...
        n -> 1/n -> Math.random() ->

        1000명 참석 경품의 1등 고르기 하면 1/1000 -> Math.random(1000)
     */


    private void refreshListNode() {

    }

    // 10,1,10,20,100 / 1000번 오차범위가 줄어들지 않았을까...
    // 132, 66, 66, 67, [null,10,10,1,20,100,20,1,100,10,10,10,10,1,100,20,20,100,10,1,10,10,100,10,1,20,20,100,10,1,10,20,10,100,1,10,10,10,100,1,20,10,100,20,1,10,20,100,10,1,10,10,1,20,100,10,1,10,100,10,20,100,10,10,20,1,20,100,10,10,1,10,100,1,20,10,10,100,20,1,10,1,20,100,10,10,100,10,20,10,1,10,10,1,100,20,1,100,10,20,10,100,10,1,10,20,10,10,20,1,100,10,10,100,20,1,10,100,1,20,10,10,10,100,1,20,20,10,1,10,100,100,10,10,20,1,10,1,20,10,100,10,10,20,100,1,100,10,20,10,1,100,10,1,10,20,10,20,10,100,1,100,10,10,20,1,10,100,20,1,10,10,1,20,100,10,100,10,20,1,10,10,1,10,20,100,1,100,10,10,20,10,10,100,1,20,100,10,1,10,20,10,100,20,10,1,100,20,10,1,10,20,100,1,10,10,10,100,20,10,1,100,10,1,20,10,1,100,10,10,20,10,10,1,20,100,20,10,100,1,10,20,100,1,10,10,10,100,1,10,20,100,1,20,10,10,10,10,20,1,100,100,10,10,20,1,20,100,1,10,10,20,100,10,1,10,10,10,1,100,20,10,100,1,20,10,20,1,10,10,100,1,100,10,20,10,10,100,1,20,10,1,10,20,100,10,20,10,100,10,1,1,20,10,10,100,1,10,100,20,10,100,10,1,10,20,1,10,100,10,20,20,1...
    // 124, 65, 74, 65, [null,10,10,1,100,10,100,10,100,100,10,10,10,20,100,20,20,1,20,10,20,20,100,10,10,20,1,10,100,20,100,20,10,100,100,1,100,10,20,1,100,1,20,100,1,100,10,1,10,20,20,10,20,10,10,20,20,1,100,10,1,10,10,1,100,1,10,10,1,10,20,1,20,1,10,1,20,100,10,10,10,10,20,1,10,10,100,10,1,10,10,10,10,100,10,1,10,10,10,20,10,10,100,10,100,1,10,100,1,1,100,10,10,10,1,100,10,20,100,20,20,1,1,1,10,1,10,100,1,1,10,1,100,10,20,20,10,10,10,1,100,20,100,20,20,10,10,20,10,1,1,1,100,100,10,20,20,100,10,100,20,100,10,10,20,10,10,100,10,100,10,100,100,1,100,10,100,1,10,100,100,1,10,10,10,100,20,10,1,10,1,100,1,10,1,10,10,20,1,10,100,20,1,10,10,10,10,100,20,10,10,100,10,20,100,20,10,100,10,10,1,100,100,10,1,10,10,1,10,10,1,20,100,100,100,1,1,100,10,1,20,10,10,100,10,100,10,10,20,100,10,100,20,100,100,10,1,20,20,1,100,10,100,20,1,20,1,20,100,20,1,20,10,10,10,10,20,1,10,100,10,1,10,1,10,100,20,100,20,1,10,100,20,1,100,10,10,10,10,20,20,1,1,10,10,10,10,100,1,1,20,100,20,20,10,20,10,10,100,20,20,1,100,10,10,20,100,10,20,1...

}