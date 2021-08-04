package aug;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3837/
public class Solution0804 {
    int i = 0;

    // 중복되지 않은 set 구하기
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // subSet(1,2,3,4) => [1, subSet(2,3,4)]
        // subSet(2,3,4) => [2, subSet(3,4)]
        // subSet(3,4) => [3, subSet(4)]
        // subSet(4) => [4, subSet()]
        // subSet() => []

        //
        List<List<Integer>> res = new ArrayList<>();

        return res;
    }
}
