package y2022.apr;

import model.TreeNode;
import y2021.aug.Codec;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Solution0418 {
    public int kthSmallest(TreeNode root, int k) {
        /*
           bst 에서 K번째 (1 index) 값을 찾기

           1. 가장 작은 값이 있을때까지 DFS한다음에 root left == null일때 pop , 어레이리스트에다가 추가 , 갯수가 k만큼되며는 그냥 추가하지않고 종료
           2. cnt ->

           bst -> in-order travel l -> m -> r
         */

        inorder(root, k);

        //System.out.println(cnt);
        System.out.println();

        /*
        Follow up: If the BST is modified often
        (i.e., we can do insert and delete operations) and
        you need to find the kth smallest frequently, how would you optimize?

        1. 처음에 k 번째 값을 찾기
        2. 낮은 값이 들어오면 k 를 밀어 처리하고 -> k 앞을 다 기억 [바로 앞거는 알아야함]
        3. 높은 값이 들어오면 무시

        list -> 한벌 더 보관해야 하는거 아닌가?
        [a,b,c,d,e,f,g] -> linked list // array list
               ^
        [binarysearch -> logn]

                d
              b   f
            a   ce g
           [a c c d e f g]

         */

        return value;
    }

    /*
                  6
                4   7
              2  5
             1 3
     */
    int cnt = 0, value = 0;
    private void inorder(TreeNode node,int k) {
        if (node == null || cnt >= k) {
            return ;
        }
        // 왼 탐색 -> 로직 -> 오른 탐색
        // 로직 -> 왼 탐색 -> 오른 탐색
        // 왼 탐색 -> 오른 탐색 -> 로직
        inorder(node.left, k);
        cnt++;
        if (cnt == k) {
            value = node.val;
        }
        //System.out.print(node.val + " -> ");
        inorder(node.right, k);
    }

    public static void main(String[] args) throws Exception {
        Solution0418 s = new Solution0418();
        Codec c = new Codec();

        System.out.println(s.kthSmallest(c.deserialize("5,3,6,2,4,null,null,1"), 3));
    }

}
