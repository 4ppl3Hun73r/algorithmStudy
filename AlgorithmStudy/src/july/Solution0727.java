package july;

public class Solution0727 {
    public TreeNode sortedArrayToBST(int[] nums) {

        // nums => 오름차순 정렬된 숫자
        // treeNode -> 높이 균형 트리로 만들어야

        //                         [root] 홀수, 짝수 왼쪽으로 골라서 root
        // [nums] ->    [num1]       /      [num2]
        //        [num1-1] [num1-2]     [num2-1] [num2-2]
        //
        return recursive(nums, 0, nums.length - 1);
    }

    // 1, 3
    private TreeNode recursive(int[] nums, int start, int end) {
        // 종료조건
        if (start > end) {
            return null;
        }

        // start : 0, end 1
        int medianIndex = (start + end) / 2;
        // min : 0
        TreeNode root = new TreeNode(nums[medianIndex]);
        // start : 0, end: -1
        root.left = recursive(nums, start, medianIndex - 1);
        // start : 1, end 1
        root.right = recursive(nums, medianIndex + 1, end);
        return root;
    }

    class TreeNode {
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