package contest;

import java.util.*;

public class Contest90 {


    public List<List<Integer>> findWinners(int[][] matches) {
        /*
        matches -> winner, loser


         */

        TreeSet<Integer> winAllMatch = new TreeSet<>();
        TreeSet<Integer> loseOnlyOneMatch = new TreeSet<>();

        Map<Integer, Integer> loseCnt =  new HashMap<>();
        for (int[] match : matches) {
            winAllMatch.add(match[0]);
            loseCnt.put(match[1], loseCnt.getOrDefault(match[1], 0) + 1);
        }
        for (int[] match : matches) {
            winAllMatch.remove(match[1]);
            if (loseCnt.get(match[1]) == 1) {
                loseOnlyOneMatch.add(match[1]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(winAllMatch));
        ans.add(new ArrayList<>(loseOnlyOneMatch));
        return ans;

    }


    public static void main(String[] args) {
        Contest90 c = new Contest90();

    }
}
