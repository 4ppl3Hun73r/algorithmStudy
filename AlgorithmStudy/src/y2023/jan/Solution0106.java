package y2023.jan;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-ice-cream-bars/
public class Solution0106 {
    public int maxIceCream(int[] costs, int coins) {
        // 오느
        // 마이크가 이상하네요
        Arrays.sort(costs); // O(NlonN)
        int bars = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                bars++;
                coins-=cost;
            }
        }

        // max -> 값 100000
        // [  1 2 3 ]
        // for [] -> 0 아니면 coins -= [i] * idx;
        // 1000000 + 1000000 -> 해결이 되는데 -> / new 연산..... /
        // 100000 + 600000 -> 1600000

        return bars;
    }
}
