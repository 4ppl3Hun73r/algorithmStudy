package y2022.nov;

import java.util.*;

// https://leetcode.com/problems/find-players-with-zero-or-one-losses/
public class Solution1128 {
    public List<List<Integer>> findWinners(int[][] matches) {

        // 한번도 진적 없는 딱 한번 진거
        TreeSet<Integer> winners = new TreeSet<>();
        List<Integer> losers = new ArrayList<>();
        TreeMap<Integer, Integer> losersMap = new TreeMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            winners.add(winner);
            losersMap.put(loser, losersMap.getOrDefault(loser, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> loserCntEntry : losersMap.entrySet()) {
            winners.remove(loserCntEntry.getKey());
            if (loserCntEntry.getValue() == 1) {
                losers.add(loserCntEntry.getKey());
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(winners));
        ans.add(losers);
        return ans;
    }
}
