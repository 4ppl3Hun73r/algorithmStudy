package contest;

import model.TreeNode;
import y2021.aug.Codec;

import java.util.ArrayList;
import java.util.List;

public class Contest3 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> startNode = new ArrayList<>();
        List<String> destNode = new ArrayList<>();

        /*
        () -> LL
        () -> RL
        LL () RL
        UURL

        ()
        () -> L
        () L
        L

        () R L
        () R R

        L () R
        U R

         */

        createDirection(root, startValue, startNode);
        createDirection(root, destValue, destNode);

        System.out.println(startNode);
        System.out.println(destNode);

        int len = Math.min(startNode.size(), destNode.size());

        int index = 0;
        for (index = 0; index < len; index++) {
            if (!startNode.get(index).equals(destNode.get(index))) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = startNode.size() - 1; i >= index; i--) {
            sb.append("U");
        }
        for (int i = index; i < destNode.size(); i++) {
            sb.append(destNode.get(i));
        }

        return sb.toString();

    }

    private boolean createDirection(TreeNode node, int val, List<String> list) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            return true;
        }
        list.add("L");
        if (createDirection(node.left, val, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        list.add("R");
        if (createDirection(node.right, val, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Contest3 c = new Contest3();
        Codec cd = new Codec();

        // "UUR" "U"
        System.out.println(c.getDirections(cd.deserialize("5,8,3,1,null,4,7,6,null,null,null,null,null,null,2"), 4, 3));
        /*System.out.println(c.getDirections(cd.deserialize("5,1,2,3,null,6,4"), 3, 6));
        System.out.println(c.getDirections(cd.deserialize("5,1,2,3,null,6,4"), 6, 4));
        System.out.println(c.getDirections(cd.deserialize("5,1,2,3,null,6,4"), 4, 6));
        System.out.println(c.getDirections(cd.deserialize("2,1"), 1, 2));
        System.out.println(c.getDirections(cd.deserialize("2,1"), 2, 1));*/


    }
}
