package y2023.feb;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
public class Solution0207 {
    public int totalFruit(int[] fruits) {

        /*
          [0, 0]
          [1,2,3,2,2,4,4,4,6]
           L
           R

           <

           1,2


            1,2 = idx = 0
            1,2,3 = idx = 1
            2,3 = idx = 1

            2,3,2,2 = idx = 1

            2,3,2,2,4 = idx
            ^
            3,2,2,4 = idx++ 2
            ^
            2,2,4 = idx++

            2,2,4,4,4 =
            ^ ^ 4,4,4 6


         */
        Map<Integer, Integer> kindCountMap = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < fruits.length; right++) {
            int tree = fruits[right];
            kindCountMap.put(tree, kindCountMap.getOrDefault(tree, 0) + 1);

            while(kindCountMap.size() > 2) {
                Integer leftTree = fruits[left];
                kindCountMap.put(leftTree, kindCountMap.get(leftTree) - 1);
                if (kindCountMap.get(leftTree) == 0 ) {
                    kindCountMap.remove(leftTree);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
