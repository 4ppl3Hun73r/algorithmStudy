package problems;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        connectChild(root);
        connectEdge(root);

        return root;
    }

    private void connectChild(Node node) {
        if (node == null) {
            return ;
        }

        if (node.left != null) {
            node.left.next = node.right;
        }

        connectChild(node.left);
        connectChild(node.right);
    }

    private void connectEdge(Node node) {
        if (node == null) {
            return ;
        }

        connectEdge(node.left);
        connectEdge(node.right);

        Node leftEdge = node.left;
        Node rightEdge = node.right;
        while (leftEdge != null && rightEdge != null) {
            leftEdge = findChildEdge(leftEdge, false);
            rightEdge = findChildEdge(rightEdge, true);
            if (leftEdge != null && rightEdge != null) {
                leftEdge.next = rightEdge;
            }
        }
    }

    private Node findChildEdge(Node node, boolean leftFirst) {
        if (node != null) {
            if (leftFirst) {
                if (node.left != null) return node.left;
                if (node.right != null) return node.right;
            } else {
                if (node.right != null) return node.right;
                if (node.left != null) return node.left;
            }
        }

        return null;
    }

    // next 이용하는건 생각도 못함 ㅠㅠ
    public Node connect2(Node root) {
        Node level_start = root;
        while(null!=level_start){
            Node cur = level_start;
            while(null!=cur){
                if(null!=cur.left)
                    cur.left.next=cur.right;
                if(null!=cur.right && null!=cur.next)
                    cur.right.next=cur.next.left;
                cur=cur.next;
            }
            level_start=level_start.left;
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