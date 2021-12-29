package dec;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class Solution1229 {
    public Node connect(Node root) {
        /*
               1 -> null
              / \
             2 ->3 -> null
            / \  / \
           4 ->5>6->7 -> null
         */
        // BFS -> 쉽게 풀릴것 같은데 space O(n)
        //
        if (root == null) return root;
        Node node = root;
        while (node.left != null) {
            Node next = node;
            while (next != null) { // bb bb
                if (next.left != null) {
                    next.left.next = next.right;
                }
                if (next.next != null) {
                    next.right.next = next.next.left; // or right
                }
                next = next.next;
            }
            node = node.left;
        }
        return root;
    }

    public Node connectBFS(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size() - 1;
            Node prev = queue.poll();
            queue.add(prev.left);
            queue.add(prev.right);
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                prev.next = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                prev = node;
            }
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};