package y2023.mar;

import model.ListNode;

import java.util.Random;

// https://leetcode.com/problems/linked-list-random-node/
public class Solution0310 {
}

class Solution {
    Random random = new Random();
    ListNode head = null;
    ListNode tail = null;
    int len = 0;
    public Solution(ListNode head) {
        this.head = head;
        while (head != null) {
            tail = head;
            head = head.next;
            len++;
        }
    }

    public void addList(ListNode node) {
        tail.next = node;
        tail = node;
        len++;
    }

    /** Returns a random node's value. */
    public int getRandomReservoirSampling() {
        int scope = 1, chosenValue = 0;
        ListNode curr = this.head;
        while (curr != null) { // O(n)
            // decide whether to include the element in reservoir
            // math.random -> 0.0 <= r < 1.0
            if (Math.random() < (1.0 / scope)) // 우변 :  1, 1/2, 1/3 ~~
                chosenValue = curr.val;
            // move on to the next node
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;

    }

    public int getRandom() {
        int pick = random.nextInt(len);

        ListNode temp = head;
        for (int i = 0; i < pick; i++) {
            temp = temp.next;
        }

        return temp.val;
    }
}