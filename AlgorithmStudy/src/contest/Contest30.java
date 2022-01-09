package contest;

import model.ListNode;

import java.util.Stack;

public class Contest30 {
    public int pairSum(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }


        int half = count / 2;
        temp = head;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < half; i++) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int max = 0;
        for (int i = 0; i < half; i++) {
            max = Math.max(stack.pop() + temp.val, max);
            temp = temp.next;
        }

        return max;
    }

    public static void main(String[] args) {
        Contest30 c = new Contest30();
    }
}
