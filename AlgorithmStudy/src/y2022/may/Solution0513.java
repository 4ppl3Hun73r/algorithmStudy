package y2022.may;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class Solution0513 {
    // problems.PopulatingNextRightPointersInEachNode2
    public Node connect(Node root) {
        /*
        next pointer 연결 시키기

        Follow-up:
        You may only use constant extra space.
        The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
         */
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