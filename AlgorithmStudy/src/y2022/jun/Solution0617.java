package y2022.jun;

import model.TreeNode;
import y2021.aug.Codec;

// https://leetcode.com/problems/binary-tree-cameras/
public class Solution0617 {

    int camera = 0;
    public int minCameraCover(TreeNode root) {
        /*
        하나의 카메라는 부모, 자기 자신, 자식 을 커버한다.
        최소한으로 설치해야 하는 카메라 수.

        DP, DFS
            N
           /
          C    -> 카메라 설치
         / \
        N   N

              C
             /
            N   -> 카메라 설치
           /
          N
         /
        C       -> 카메라 설치
         \
          N
          dfs(left) == -1 && dfs(right) == -1 -> 부모에 위임 / if (node == null) return -1;

        N

        N
       /
      N
            N
           /
          N
         /
        N
             C
           /   \
          C     N
         / \
        N   C
             \
              N
         */

        camera = 0;

        NodeStatus status = dfs(root);
        if (status == NodeStatus.INSTALL_CAMERA) {
            camera++;
        }

        return camera;
    }

    enum NodeStatus {
        LEAF,
        INSTALL_CAMERA,
        COVERED
    }

    private NodeStatus dfs(TreeNode node) {
        if (node == null) {
            return NodeStatus.LEAF;
        }
        NodeStatus left = dfs(node.left);
        NodeStatus right = dfs(node.right);
        if (left == NodeStatus.LEAF && right == NodeStatus.LEAF) {
            return NodeStatus.INSTALL_CAMERA; // 부모에 위임
        }
        if (left == NodeStatus.INSTALL_CAMERA || right == NodeStatus.INSTALL_CAMERA) {
            // 카메라 설치
            //System.out.println(node.val);
            camera++;
            return NodeStatus.COVERED; // 카메라가 설치 되었다.
        }
        //if (left == NodeStatus.VIEW || right == NodeStatus.VIEW) {
        return NodeStatus.LEAF;
        //}
        //return 1;
    }

    public static void main(String[] args) throws Exception {
        Solution0617 s = new Solution0617();

        Codec c = new Codec();

        //System.out.println(s.minCameraCover(c.deserialize("0,0,null,0,0")));

        //System.out.println(s.minCameraCover(c.deserialize("1,2,null,3,null,4,null,null,5")));

        System.out.println(s.minCameraCover(c.deserialize("1,2,null,3,null,4,null,null,5,6,7,8,null,null,9")));
    }

    /*
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return Math.min(res[1], res[2]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0, Integer.MAX_VALUE / 2};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[3];
        res[0] = left[1] + right[1];
        res[1] = Math.min(left[2] + Math.min(right[1], right[2]), right[2] + Math.min(left[1], left[2]));
        res[2] = 1 + Math.min(left[0], Math.min(left[1], left[2])) + Math.min(right[0], Math.min(right[1], right[2]));
        return res;
    }
    */
}
