package y2022.jan;

import model.ListNode;

import java.util.Random;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class Solution0119 {
    public ListNode detectCycle(ListNode head) {
        /* 제약 조건에 걸려요....
        // Do not modify the linked list.
        while (head == null) {
            head.val = -1;
            if (head.val == -1) {
                return head;
            }
        }
        */
        /*
         A -> B -> C -> D -> E -> F -> C
                   ^ -> 반환
         */
        // O(1) 순환 탐지 알고리즘
        /*
        fast / slow ->

        A -> B -> C -> D -> E -> F -> B -> C -> D -> E -> F -> B -> C -> D -> E -> F -> B -> C -> D -> E -> F -> B -> C -> D -> E -> F -> B
                                      ^
                                                          ^
             ^
                       // ? B 를 찾는 방법?
        A -> B -> C -> D -> E -> F -> B -> C -> D -> E -> F -> B -> C -> D -> E -> F -> B
      S                 ^                        ^

        A -> B -> C -> D -> E -> F -> C -> D -> E -> F -> C -> D -> E -> F -> C
                  ^                   ^

        A -> B -> C -> D -> E -> F -> E -> F -> E -> F -> E -> F -> E
                                                ^
                                                ^
                            ^

        A -> B -> C -> D -> E -> F -> C -> D -> E -> F -> C -> D -> E -> F -> C -> D -> E -> F -> C -> D -> E -> F -> C
      S                               ^
      F                                                                                 ^
      T           ^
      Q                     ^


       A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> F -> G -> H -> I -> J -> K -> F -> G -> H -> I -> J -> K -> F
     S                                                        ^
     F                                                             ^
     T                          ^


        L => 전체 길이 -> 6이고...
        SLOW -> 4를 갔을떄
        FAST -> 8을 가는건데...
        순환 시작 지점은 -> L - FAST - SLOW  ???
        memory O(1)


        1 2 3 4 2 3 4 2 3 4 2 3 4 2 3 4 2 3 4 2 3 4
        L, C
        L + 2 * C -> n번만 순환한다고 했을때의 리스트의 전체길이
        R = L - C
        S = 1
        F = 2 * S



         */


        // Floyd's Tortoise and Hare Algorithm: Finding a Cycle in a Linked List
        // https://leetcode.com/problems/linked-list-cycle-ii/discuss/1203738/142-Floyd's-Tortoise-and-Hare-Algorithm%3A-Finding-a-Cycle-in-a-Linked-List
        /*

                   a              b
        head - - - - - - - -> P - - -> Q
                             /         \
                            |           |
                             \         /
                                - - -
                                      c

        From 'head' point:
        -       Walk 'a' distance, to go to P
        - then, Walk 'b' distance, to go to Q
        - then, Walk 'c' distance, to go to P again

        Assume, two persons slow & fast
            start at 'head' point &
            meet at point Q
        If slow & fast meet at Q point, we know there is a cycle
        The fast is twice as fast as slow person.
            slow walks +1
            fast jumps +2
        so, slow travelled = a+b
            fast travelled = a+b +c+b    = a+2b+c
        since speed wise, we know
               fast    == 2 x slow
            => a+2b+c  == 2(a+b)
            => a+2b +c == a+ a+2b
            =>       c == a
        Once slow & fast meet at Q point, how can we find point P where both met first?
        Assume
               a slow p1 starts from head &
         another slow q1 starts from Q/slow)
         since c == a, they must meet at point P
             So we now know the point P (where the cycle begins)

        This is  Floyd's Tortoise and Hare Algorithm:  Finding a Cycle in a Linked List

        https://neurowhai.tistory.com/384
        */

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //??? B를 찾아야 되요..
                // 순환은 있다.
                ListNode newHead = head;
                while (newHead != slow) {
                    newHead = newHead.next;
                    slow = slow.next;
                }
                return newHead;
            }
        }

        return null;
    }
    
    public static void main(String[] args) throws Exception {
        Solution0119 s = new Solution0119();
        ListNode t = new ListNode(1);
        ListNode head = t;
        Random random = new Random();
        ListNode c = null;
        for (int i = 1; i < 10000; i++) {
            t.next = new ListNode(i);
            t = t.next;
            if (random.nextBoolean()) {
                c = t;
            }
        }
        t.next = c;

        System.out.println(s.detectCycle(head) == c);
    }
    
}
