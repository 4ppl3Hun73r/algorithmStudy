package y2022.aug;

import model.ListCodec;
import model.ListNode;

// https://leetcode.com/problems/palindrome-linked-list/
public class Solution0823 {
    public boolean isPalindrome(ListNode head) {
        /*
        LinkedList 가 회문인지 확인
        1 -> 2 -> 2 -> 1

        Follow up : time O(n), space O(1) 로 가능?
         */
        /*Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.offer(head);
            head = head.next;
        }

        while (deque.size() > 1) {
            if (deque.pollFirst().val != deque.pollLast().val) {
                return false;
            }
        }*/

        /*
         1 -> 2 -> 1
         1 -> 2 -> 2 -> 1

         cnt
         pointer 를 중간 지점까지 보내기
         1 <- 2 /  2 -> 1
              ^    ^

         두개 포인터로 탐색

         cnt N
         half   N/2
         search N/2
         2N -> O(n)
         */
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // reverse half
        ListNode left = null;
        ListNode curr = head;
        temp = head;
        ListNode right = head;
        for (int i = 0; i < (cnt / 2); i++) {
            right = right.next;

            temp = curr.next;
            curr.next = left;
            left = curr;
            curr = temp;
        }

        if (cnt % 2 == 1) {
            right = right.next;
        }
        // validation

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean isPalindromeSlowFast(ListNode head) {
        /*
          1 -> 2 -> 2 -> 1
                    ^
                             &
          2 <- 1
         */
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)  // 홀수 짝수
            slow=slow.next;

        ListNode prev=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        slow=prev;
        fast=head;
        while(slow!=null){

            if(slow.val!=fast.val)
                return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Solution0823 s = new Solution0823();
        ListCodec c = new ListCodec();

        System.out.println(s.isPalindrome(c.deserialize("1,2,2,1")));
        System.out.println(s.isPalindrome(c.deserialize("1,2,3,2,1")));
        System.out.println(s.isPalindrome(c.deserialize("1")));
        System.out.println(s.isPalindrome(c.deserialize("1,2,3")));
        System.out.println(s.isPalindrome(c.deserialize("1,2,3,4,5")));
        System.out.println(s.isPalindrome(c.deserialize("1,2,3,4,5,6")));
    }
}

