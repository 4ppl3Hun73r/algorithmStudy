package problems;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty()) {
            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();

            if (n1 != null && n2 != null) {
                if (n1.val == n2.val) {
                    queue1.add(n1.left);
                    queue1.add(n1.right);

                    queue2.add(n2.left);
                    queue2.add(n2.right);
                } else {
                    return false;
                }
            } else if (!(n1 == null && n2 == null)) {
                return false;
            }
        }

        return true;
    }
}
