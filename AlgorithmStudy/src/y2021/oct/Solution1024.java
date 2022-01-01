package y2021.oct;

import model.TreeNode;
import y2021.aug.Codec;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class Solution1024 {

    int result = 1;
    public int countNodes(TreeNode root) {
        /*
        1 - 1
        2 - 1 + 2
        3 - 1 + 2 + 4
        4 - 1 + 2 + 4 + 8

        1, 3, 7, 15
        2^n - 1
         */
        if (root == null) {
            return 0;
        }

        dfs(root, 1, 1);

        return result;
    }

    private boolean dfs(TreeNode node, int depth, int parentPos) {
        // 오른쪽 왼쪽이 완전하지 않은 노드를 찾아야함
        // 탐색시 오른쪽을 먼저 찾음

        if (node.left == null && node.right == null) {
            // 더이상 내려갈게 없으면....
            // 일단 이 node는 complete 노드
            return true;
        }

        if (node.left != null && node.right == null) {
            // 완전하지 않은 지점
            // 이 지점을 기준으로 전체 크기를 계산 할수 있어야함.
            // 오른쪽 기준으로 탐색했기 때문에 이 지점의 depth 는 모두 완전함.
            result = (int)Math.pow(2, depth) - 1;
            // 이 아레 depth 를 계산 해야함.
            // 자신의 형재들관의 상대적 위치를 알면 아래 depth도 계산 가능함.
            int childPos = parentPos * 2;
            int startSiblingPos = (int)Math.pow(2, depth);
            result += (childPos) - startSiblingPos + 1;

            return false;
        }

        if (dfs(node.right, depth + 1, (parentPos * 2) + 1)) {
            // 오른쪽이 완벽이면
            // 왼쪽도 완벽한지 확인
            boolean isComplete = dfs(node.left, depth + 1, (parentPos * 2));
            if (isComplete) {
                result = Math.max(result, (parentPos * 2) + 1);
            }
            return isComplete;
       }
        return false;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution1024 s = new Solution1024();

        System.out.println(s.countNodes(codec.deserialize("1,2,3,4,5,6,7,8,9,10,null,null,null")));
    }

}
