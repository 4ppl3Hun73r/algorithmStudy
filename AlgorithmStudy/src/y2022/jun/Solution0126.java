package y2022.jun;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
public class Solution0126 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ascOrderList = new ArrayList<>();

        // -> O(NlogN)
        // BST 라서
        // in order 탐색 하면 -> 정렬 순으로 탐색 가능 bb
        // O(N + M)
        /*
        L -> Root -> R
         */

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        inOrder(root1, queue1);
        inOrder(root2, queue2);

        while( !(queue1.isEmpty() || queue2.isEmpty()) ) {
            int v1 = queue1.peek();
            int v2 = queue2.peek();

            if (v1 < v2) {
                ascOrderList.add(queue1.poll());
            } else {
                ascOrderList.add(queue2.poll());
            }
        }

        while (!queue1.isEmpty()) {
            ascOrderList.add(queue1.poll());
        }

        while (!queue2.isEmpty()) {
            ascOrderList.add(queue2.poll());
        }

        return ascOrderList;
    }

    private void inOrder(TreeNode node, Queue<Integer> queue) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left, queue);
        }

        // 로직
        queue.add(node.val);

        if (node.right != null) {
            inOrder(node.right, queue);
        }
    }
}
