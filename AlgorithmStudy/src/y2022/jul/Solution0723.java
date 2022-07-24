package y2022.jul;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class Solution0723 {
    public List<Integer> countSmaller(int[] nums) {

        /*
        nums 에서 자기 오른쪽에 자기보다 작은 수를 세기
         [5,2,6,1]
         5 => 2, 1
         2 => 1
         6 => 1
         1 =>


         [1] -> 0
         [6,1] -> 1
         [6,2,1] -> 1 -> 2의 위치는 binary search 로 찾기
         [6,5,2,1[ -> 2 -> 5의 위치는 binary search 로 찾기
         */
        List<Integer> ans = new ArrayList<>(nums.length);
        for (int num : nums) {
            ans.add(0);
        }
        List<Integer> sortedList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            int idx = binarySearch(sortedList, num);
            sortedList.add(idx, num);
            System.out.println(sortedList);

            ans.set(i, idx);
        }

        return ans;
    }


    private int binarySearch(List<Integer> sorted, int target) {
        if (sorted.size() == 0) {
            return 0;
        }

        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < target) {
            return end + 1;
        }
        if (sorted.get(start) >= target) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (sorted.get(start) >= target) {
            return start;
        }

        return end;
    }

    public static void main(String[] args) {

        Solution0723 s = new Solution0723();


        //[26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41]
        System.out.println(s.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
    }
}
