package aug;

import java.util.*;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/
public class Solution0820 {
    int m = (int) (1e9) + 7;

    Set<Long> subSet = new HashSet<>(5 * 10000);

    public int maxProduct(TreeNode root) {
        int total = sumSum(root);

        long max = 0;
        for (Long sum : subSet) {
            max = Math.max(max, sum * (total - sum));
        }
        // set 사용하면 더 느리고, 공간도 많이 사용됨
        // 두번 순회하는게 더 빠름
        // callstack 쌓이는거랑, set으로 중복 제거하는거랑
        // <-> trade off

        return (int) (max % m);
    }
    // (total_sum - subtree_sum) * subtree_sum
    private int sumSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sumSum(node.left);
        int rightSum = sumSum(node.right);
        // total

        subSet.add((long)(node.val + leftSum + rightSum));

        return node.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        Solution0820 s = new Solution0820();

        // 1,2,3,4,5,6
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));

        System.out.println(s.maxProduct(root));
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
}
