package y2022.may;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/coin-change/
public class Solution0521 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        Set<Integer> visited = new HashSet<>();

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int leftAmount = queue.poll();
                if (leftAmount == 0) {
                    return ans;
                }

                for (int coin : coins) {
                    int change = leftAmount - coin;
                    if (change >= 0 && !visited.contains(change)) {
                        queue.offer(change);
                        visited.add(change);
                    }
                }
            }

            ans++;
        }

        return -1;
    }
}
