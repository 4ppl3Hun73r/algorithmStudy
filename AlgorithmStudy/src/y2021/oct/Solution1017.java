package y2021.oct;

import model.TreeNode;
import y2021.aug.Codec;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/cousins-in-binary-tree/
public class Solution1017 {
    P x1 = null;
    P y1 = null;
    private int targetX;
    private int targetY;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.targetX = x;
        this.targetY = y;
        // 부모가 다르고 같은 depth 일때 사촌(cousins)
        // Tree, DFS, BFS, Binary Tree
        /*
               1
              / \
             2   3
            /
           4
               1
              / \
             2   3    => 2, 3은 형제/자매
            /   /
           4   5      => 4, 5는 사촌
         */

        // DFS // pair<ParentNode, depth>
        // 탐색은 다 봐야함. 왼쪽 / 오른쪽 방향으로는 못감
        getDfs(root.left, root, 1);
        getDfs(root.right, root, 1);
        if (x1 != null && y1 != null) {
            return x1.parentNode.val != y1.parentNode.val && x1.depth == y1.depth;
        }

        return false;
    }

    private void getDfs(TreeNode node, TreeNode parent, int depth) {
        if (node == null) {
            return;
        }

        if (node.val == targetX) {
            this.x1 = new P(parent, depth);
            return; // <--
        } else if (node.val == targetY) {
            this.y1 = new P(parent, depth);
            return;
        }

        getDfs(node.left, node, depth + 1);
        getDfs(node.right, node, depth + 1);
    }

    class P {
        public TreeNode parentNode;
        public int depth;
        public P(TreeNode parentNode, int depth) {
            this.parentNode = parentNode;
            this.depth = depth;
        }
    }

    public boolean isCousinsJiho(TreeNode root, int x, int y) {
        if (checkChild(root, x, y)) {
            return false;
        }
        // queue에 넣기전에 자식인 x, y인지 확인 -> return false;
        // queue에 자식을 넣음 x / y => 사촌 지간인걸 보장함


        // 부모가 다르고 같은 depth 일때 사촌(cousins)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        Set<Integer> checkSet = new HashSet<>();
        checkSet.add(x);
        checkSet.add(y);
        while (!queue.isEmpty()) {
            Set<Integer> checkSet2 = new HashSet<>(checkSet);
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    checkSet2.remove(node.val);
                    if (checkChild(node, x, y)) {
                        return false;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (checkSet2.size() == 0) {
                return true;
            }
        }

        return false;
    }

    private boolean checkChild(TreeNode node, int x, int y) {
        if (node.left == null || node.right == null) {
            return false;
        }

        boolean result = false;
        result = node.left.val == x && node.right.val == y;
        if (result) {
            return result;
        }
        result = node.left.val == y && node.right.val == x;
        return result;
    }

    public static void main(String[] args) throws Exception {
        Codec c = new Codec();
        Solution1017 s = new Solution1017();

        System.out.println(s.isCousins(c.deserialize("1,2,3,null,4,null,5"), 5, 4));
        System.out.println(s.isCousins(c.deserialize("1,2,3,null,4"), 3, 2));
        System.out.println(s.isCousins(c.deserialize("1,2,3,null,null,null,4,null,5"), 3, 2));
    }

}
