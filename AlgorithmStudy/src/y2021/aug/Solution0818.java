package y2021.aug;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3899/
public class Solution0818 {

    public int goodNodes(TreeNode root) {
        // good node 조건, 자기 부모 노드들의 값보다 같거나 클때
        // 깊이우선탐색(Depth) 으로 힌트가 나왔어요.

        return 1 + findNode(root.left, root.val) + findNode(root.right, root.val);
    }

    // 1, 4
    private int findNode(TreeNode node, int maxVal) { // node(1), 3
        int count = 0;
        if (node == null) {
            return count;
        }

        if(node.val >= maxVal){
            maxVal = node.val;
            count++;
        }

        return count + findNode(node.left, maxVal) + findNode(node.right, maxVal);
    }

    private int dfs(TreeNode node, int min, int count) {

        if (node.val >= min) {
            count++;
            min = node.val;
        }

        if (node.left != null) {
            count = dfs(node.left, min, count);
        }

        if (node.right != null) {
            count = dfs(node.right, min, count);
        }

        return count;
    }

    ///////
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution2 {
        int counter = 0 ;
        public int goodNodes(TreeNode root) {
            if(root != null) {
                dfs(root, Integer.MIN_VALUE);
            }
            return counter;
        }

        public void dfs(TreeNode root, int value){
            if(root.val >= value){
                counter++;
            }
            if(root.left != null){
                dfs(root.left, Math.max(root.val, value));
            }
            if(root.right != null){
                dfs(root.right, Math.max(root.val, value));
            }
        }
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */