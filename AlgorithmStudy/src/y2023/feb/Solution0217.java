package y2023.feb;


import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class Solution0217 {

    public int minDiffInBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        dfs(root, nodes);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nodes.size(); i++) {
            min = Math.min(min, nodes.get(i) - nodes.get(i-1));
        }

        return min;
    }

    private void dfs(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return ;
        }
        dfs(node.left, nodes);
        nodes.add(node.val);
        dfs(node.right, nodes);
    }
    /*
    11  -> tag,info
    22

    11 11 11 11                tag,info  -> 1.5 1.5
    -- 33 23 22  -> model ->                2.1 2.1

    --
    22

    0 -> n
    0 -> n -> n -> n -> ... -> 1
    0 -> n
    몇 depth ->
    개발자들의 고민
    input 을 어떻게 만들 것인가. 이미지, 목소리, 주파수, 우리의 메타를 어떻게 input화 할것인가?

    n 학습을 시키니까.

    n 을 구성할때 f(x) = ax + b -> sigmore(f(x)) -> 1억이 input -> -1 < x < 1 값으로 변경해

    output 을 어떻게 정의 할 것인가?

    chatgpt -> 체스를 가르켰데요. 룰을 제대로 학습을 못한거야.

     */

}
