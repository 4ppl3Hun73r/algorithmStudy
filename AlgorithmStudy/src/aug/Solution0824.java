package aug;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/
public class Solution0824 {

    public boolean findTarget(TreeNode root, int k) {
        // bst 에서 2개 더해서 k가 나오는 경우가 있으면 true, 아니면 false
        // two sum

        // array 가 아니라 binary search tree

        // Set 하나 만들어서 풀거나 < ym, jiho, jh -> 공간(n)
        // 탐색 두번 하는것도 방법 일것 같고 < sb => n * logn => O(n * logn) -> 공간(1)

        return true;
    }

    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> findValSet = new HashSet<>();

        return find(root, k, findValSet);
    }

    private boolean find(TreeNode node, int k, Set<Integer> findValSet) {
        if (node == null) {
            return false;
        }
        int val = node.val;
        int diff = k - val;
        if (findValSet.contains(diff)) {
            return true;
        }
        findValSet.add(val);

        return find(node.left, k, findValSet) || find(node.right, k, findValSet);
    }

    public static void main(String[] args) {
        Solution0824 s = new Solution0824();
        Codec c = new Codec(); // b

        System.out.println(
                s.findTarget(c.deserialize("5,3,6,2,4,null,7"), 9)
        );
    }

}


