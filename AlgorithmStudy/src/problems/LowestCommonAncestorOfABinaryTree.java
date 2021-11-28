package problems;

import aug.Codec;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 공통 조상을 찾아라
        /*
        찾고자 하는게 왼쪽 오른쪽에 있으면 공통 조상
        한쪽에 몰려 있으면 그쪽으로 찾아야함
        bst 아님
             3
            /
           1
        일때 3이 조상이 됨

        -----
        둘을 찾음
        검색 경로의 부모를 리스트로 저장해 놓음
        최소한 맞는걸 찾음?

        리스트 비교로 다시 찾는게 비용이 클것 같음 -> 어차피 depth == index 여서 비교가 쉬울듯. O(depth)
        [1,2,3,4,5,6,7,10]
        [1]
        -----
       */

        List<TreeNode> pAncestor = new ArrayList<>();
        List<TreeNode> qAncestor = new ArrayList<>();

        findAncestor(root, p, pAncestor);
        findAncestor(root, q, qAncestor);

        System.out.println(pAncestor);
        System.out.println(qAncestor);

        int minLen = Math.min(pAncestor.size(), qAncestor.size());

        for (int i = minLen - 1; i >= 0; i--) {
            TreeNode pA = pAncestor.get(i);
            TreeNode qA = qAncestor.get(i);

            if (pA.val == qA.val) {
                return pA;
            }
        }

        return root;
    }

    private boolean findAncestor(TreeNode node, TreeNode p, List<TreeNode> pAncestor) {
        if (node == null) {
            return false;
        }

        pAncestor.add(node);
        if (node.val == p.val) {
            return true;
        }
        if (findAncestor(node.left, p, pAncestor)) {
            return true;
        }
        if (findAncestor(node.right, p, pAncestor)) {
            return true;
        }
        pAncestor.remove(pAncestor.size() - 1);

        return false;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree l = new LowestCommonAncestorOfABinaryTree();

        Codec c = new Codec();

        System.out.println(l.lowestCommonAncestor(c.deserialize("3,5,1,6,2,0,8,null,null,7,4"), c.deserialize("7"), c.deserialize("4")).val);
    }
}
