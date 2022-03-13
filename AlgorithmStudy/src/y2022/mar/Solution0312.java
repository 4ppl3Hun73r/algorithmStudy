package y2022.mar;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class Solution0312 {
    public Node copyRandomList(Node head) {

        Map<Node, Node> nodePairMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            nodePairMap.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node newNode = nodePairMap.get(temp);

            newNode.next = nodePairMap.get(temp.next);
            newNode.random = nodePairMap.get(temp.random);

            temp = temp.next;
        }

        return nodePairMap.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
