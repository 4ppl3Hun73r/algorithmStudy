package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {

        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        return ans;

    }


    private void preorder(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);

            for (Node child : node.children) {
                preorder(child, result);
            }
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}