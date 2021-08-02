package aug;

import java.util.*;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/
public class Solution0802 {

    Map<Integer, Integer> map = new HashMap<>();
    int[][] 상하좌우 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Integer[][] newMap;
    Integer 영역번호 = 0;

    public int largestIsland(int[][] grid) {
        int area = 0;


        return area;
    }
    
    public static void main(String[] args) {
        Solution0802 solution0802 = new Solution0802();

        // int[][] grid = {{1,1},{0,1}};
        int[][] grid = {{1,1,0,0,1},{1,1,0,0,1},{1,1,0,1,1},{1,1,0,1,1},{1,1,0,1,1}};

        System.out.println(solution0802.largestIsland(grid));
    }
}
