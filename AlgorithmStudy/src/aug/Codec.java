package aug;

import java.util.*;
import model.TreeNode;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t != null) {
                result.add("" + t.val);
                q.add(t.left);
                q.add(t.right);
            } else {
                result.add("null");
            }
        }

        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = createNode(nodes[0]);
        q.add(root);
        for (int i = 1; (i < nodes.length) && !q.isEmpty(); i+=2) {
            TreeNode left = createNode(nodes[i]);
            TreeNode right = null;
            if (i + 1 < nodes.length) {
                right = createNode(nodes[i + 1]);
            }
            TreeNode parent = q.poll();
            parent.left = left;
            parent.right = right;
            if (left != null) {
                q.add(left);
            }
            if (right != null) {
                q.add(right);
            }
        }

        return root;
    }


    private TreeNode createNode(String s) {
        if (s.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(s, 10));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        Codec ser = new Codec();
        Codec deser = new Codec();

        TreeNode r2 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(ser.serialize(r2));
        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println(ans);
        ans = deser.deserialize("1,null,2,3");

        System.out.println(ans);
    }
}
