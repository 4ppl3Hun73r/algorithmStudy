package y2023.feb;

import model.GridCodec;

// https://leetcode.com/problems/construct-quad-tree/
public class Solution0227 {

    public Node construct(int[][] grid) {
        /*
            일단 노드를 다 달고 합치는 작업 진행
         */

        // 하위 노드 생성
        int len = grid.length;

        /*
        4칸 보고 4칸이 같으면 하나로 머지
         */
        return helper(grid, 0, 0, len);
    }

    private Node helper(int[][] grid, int x, int y, int depth) {
        if (depth == 1) {
            return new Node(grid[x][y] == 1, true);
        }

        int nextDepth = depth / 2;
        Node topLeft = helper(grid, x, y, nextDepth);
        Node topRight = helper(grid, x, y + nextDepth, nextDepth);
        Node bottomLeft = helper(grid, x + nextDepth, y, nextDepth);
        Node bottomRight = helper(grid, x + nextDepth, y + nextDepth, nextDepth);

        if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                return new Node(topLeft.val, true);
            }
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) throws Exception {
        Solution0227 s = new Solution0227();
        GridCodec g = new GridCodec();

        System.out.println(s.construct(g.getIntGrid("[[0,1],[1,0]]")));
        //System.out.println(s.construct(g.getIntGrid("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]")));
    }

}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    /*
    [[1,1,0,0],
     [0,0,1,1],
     [1,1,0,0],
     [0,0,1,1]]

     */
};