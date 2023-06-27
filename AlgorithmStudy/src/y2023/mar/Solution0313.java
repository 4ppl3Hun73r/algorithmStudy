package y2023.mar;

import model.TreeNode;

// https://leetcode.com/problems/symmetric-tree/
public class Solution0313 {

    public boolean isSymmetric(TreeNode root) {

        return equals(root.left, root.right);
    }

    private boolean equals(TreeNode node, TreeNode node2) {
        if (node == null && node2 == null) {
            return true;
        }

        if (node == null || node2 == null) {
            return false;
        }

        return node.val == node2.val && equals(node.left, node2.right) && equals(node.right, node2.left);
    }
//안들리시나요? 엇 재접 해보겠습니다
    //들리시나영   네 저는 들리는데 제 음성이 안넘어가나보네요
    // 들리시ㅏ요?요
    // 그러니까요 ㅠㅠ 음성이 문제네요..넵
    //넵 제출했더니 코드 하나만 있더라구요 다 같은 코드쓰나봐요
    // ㅋㅋㅋㅋㅋ BFS로도 풀어보나요?
    // 맞습니당 넵 ! 고생하셨습니다 ㅠㅋㅋ

    //      1
    //  2        2
    // 3  4    4   3
    //5 6         6 5
    // 7 8       8 7

}
