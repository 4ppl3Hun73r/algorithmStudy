package y2022.sep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0905 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        dfs(root, 0, ans);

        return ans;
    }

    private void dfs(Node node, int depth, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }

        if (ans.size() <= depth) {
            ans.add(depth, new ArrayList<>());
        }

        ans.get(depth).add(node.val);

        for (Node child : node.children) {
            dfs(child, depth + 1, ans);
        }
    }

    public List<List<Integer>> levelOrderBFS(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                subAns.add(current.val);
                for (Node child : current.children) {
                    queue.offer(child);
                }
            }
            ans.add(subAns);
        }

        return ans;
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