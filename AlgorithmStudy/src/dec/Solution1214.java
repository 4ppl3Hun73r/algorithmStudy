package dec;

import aug.Codec;
import model.TreeNode;

import java.util.HashSet;

public class Solution1214 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        HashSet<Integer> set = new HashSet<>();
        makeSet(root, low, high, set);

        int sum = 0;
        for (Integer i : set) {
            sum += i;
        }

        return sum;
    }

    private void makeSet(TreeNode node, int low, int high, HashSet<Integer> set) {
        if (node == null) {
            return ;
        }

        int val = node.val;
        if (low <= val && val <= high) {
            set.add(node.val);
        }
        if (low < val) {
            makeSet(node.left, low, high, set);
        }
        if (low >= val) {
            makeSet(node.right, low, high, set);
        }

        if (high > val) {
            makeSet(node.right, low, high, set);
        }
        if (high <= val) {
            makeSet(node.left, low, high, set);
        }
    }

    public static void main(String[] args) throws Exception {
        Solution1214 s = new Solution1214();
        Codec c = new Codec();
        System.out.println(s.rangeSumBST(c.deserialize("10,5,15,3,7,null,18"), 7, 15));
    }
}
