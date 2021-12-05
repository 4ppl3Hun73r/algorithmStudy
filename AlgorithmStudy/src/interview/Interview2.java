package interview;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Interview2 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1Leaf = new ArrayList<>();
        List<Integer> tree2Leaf = new ArrayList<>();

        findLeaf(root1, tree1Leaf);
        findLeaf(root2, tree2Leaf);

        if (tree1Leaf.size() != tree2Leaf.size()) {
            return false;
        }

        for (int i = 0; i < tree1Leaf.size(); i++) {
            if (!tree1Leaf.get(i).equals(tree2Leaf.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void findLeaf(TreeNode node, List<Integer> treeLeaf) {
        if (node == null) {
            return ;
        }

        if (node.left == null && node.right == null) {
            treeLeaf.add(node.val);
            return;
        }

        findLeaf(node.left, treeLeaf);
        findLeaf(node.right, treeLeaf);
    }
}
