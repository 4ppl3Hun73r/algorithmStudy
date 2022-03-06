package contest;

import model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Contest83 {

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> treeMap = new HashMap<>();
        Set<Integer> rootSet = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2]; // 1 -> left, 0 - right

            TreeNode pNode = treeMap.get(parent);
            if (pNode == null) {
                pNode = new TreeNode(parent);
                treeMap.put(parent, pNode);
                rootSet.add(parent);
            }
            TreeNode cNode = treeMap.get(child);
            if (cNode == null) {
                cNode = new TreeNode(child);
                treeMap.put(child, cNode);
            }
            if (isLeft == 1) {
                pNode.left = cNode;
            } else {
                pNode.right = cNode;
            }
            rootSet.remove(child);
        }



        return treeMap.get(rootSet.iterator().next());
    }

    public static void main(String[] args) {
        Contest83 c = new Contest83();

        c.createBinaryTree(new int[][]{
                {85,82,1},
                {74,85,1},
                {39,70,0},
                {82,38,1},
                {74,39,0},
                {39,13,1}
        });

    }
}
