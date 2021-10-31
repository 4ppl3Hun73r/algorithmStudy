package oct;

import model.Node;

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class Solution1031 {
    public Node flatten(Node head) {
        // 더블 링크드 리스트에서
        // 자식이 있으면 자식을 next로 변경
        Node node = getLastNode(head);
        return head;
    }

    private Node getLastNode(Node node) {
        Node prev = node;
        while (node != null) {
            // next 방향으로 탐색 시작
            if (node.child != null) {
                // 자식이 있으면 next, child, prev에 변경이 일어남
                Node findNode = getLastNode(node.child); // dps 탐색
                findNode.next = node.next;
                if (node.next != null) {
                    node.next.prev = findNode;
                }
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            }
            prev = node;
            node = node.next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.child = new Node();
        head.child.child = new Node();


        Solution1031 s = new Solution1031();
        s.flatten(head);
    }

}
