package y2022.sep;

import model.TreeNode;

import java.util.Arrays;

// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
public class Solution0914 {
    private int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        /*
        탐색했을때 유사 회문이면 ans + 1
         */

        int[] oneToNine = new int[9];
        dfs(root, oneToNine);

        return ans;
    }

    private void dfs(TreeNode node, int[] oneToNine) {
        oneToNine[node.val - 1]++;

        if (node.left == null && node.right == null) {
            // 회문 체크
            System.out.println(Arrays.toString(oneToNine));
            int oddCnt = 0;
            for (int i = 0; i < oneToNine.length; i++) {
                if ((oneToNine[i] % 2) == 1) {
                    oddCnt++;
                }
            }
            if (oddCnt == 0 || oddCnt == 1) {
                ans++;
            }

            oneToNine[node.val - 1]--;
            return ;
        }

        if (node.left != null) {
            dfs(node.left, oneToNine);
        }

        if (node.right != null) {
            dfs(node.right, oneToNine);
        }

        oneToNine[node.val - 1]--;
    }
}
