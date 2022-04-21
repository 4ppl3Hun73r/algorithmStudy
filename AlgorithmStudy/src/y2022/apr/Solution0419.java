package y2022.apr;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/recover-binary-search-tree/
public class Solution0419 {

    TreeNode prev = null;
    List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);

        if (list.size() == 2) {
            swap(list.get(0), list.get(1));
        } else {
            swap(list.get(0), list.get(3));
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return ;
        }
        inorder(node.left);
        // prev 값은 현재 값보다 작아야 한다.
        if (prev != null && prev.val > node.val) {
            list.add(prev);
            list.add(node);
        }
        prev = node;
        inorder(node.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }

    // ArrayList<TreeNode> swapCandi = new ArrayList<>();

    public void recoverTreeFail(TreeNode root) {
        /*
               3   <-
            1     4
                 2 <-

               2    <-
            1     4
                 3  <-

                3  // min
            1       4
          2        2 // < min -> wrong  3 min, 4 max
          //  3 max, min 1

               5
            3     7
          1   2  6  9
                   8  10


                    9
                  7     11
                5    10   13
              4   6
           잘못들어간 값이 2개 존재 , 해당 값을 찾아서 정상적으로 변경
         */

        // max 고정 -> 큰게 있으면 잘 못 들어간거라고 봐야 하니까.
                  //node, min,  max
        processLeft(root.left, null, root);
        processRight(root.right, root, null);

        // int val = swapCandi.get(0).val;
        // swapCandi.get(0).val = swapCandi.get(1).val;
        // swapCandi.get(1).val = val;
    }

    /*
            10
        8       15
     6
   4
 9
     */
    private void processLeft(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return ;
        }
        // max보다 큰게 있으면 에러
        if (node.val > max.val) {
            //max 와 node 를 스왑
            swap(node, max);
        } else {
            processLeft(node.left, node, max);
            processRight(node.right, min, node);

            //jymoon processLeft(node.left, null, node);
            //jymoon processRight(node.right, node, null);
        }
    }

    private void processRight(TreeNode node, TreeNode root, TreeNode max) {
        if (node == null) {
            return ;
        }
        // max보다 큰게 있으면 에러
        if (node.val < root.val) {
            //min 와 node 를 스왑
            swap(node, root);
        } else {
            processLeft(node.left, root, node);
            processRight(node.right, node, max);
        }
    }

    /*
    9
   5
 2   7(min보다 작으니까 치환 가능)
       6

       in-order -> 정렬 되서 나오는거
       in-order -> 정렬 부분이 있으면 범인!?

        1

       1 3 2 4 -> in order?
       1,2,3,4

          3
        1
         2

        3 2 1 -> 감지? 어느 2개를 swap 하면 정상이 되는지 감지 가능?
        1 2 3
               3   <-
            1     4
                 2 <-

     */
}
