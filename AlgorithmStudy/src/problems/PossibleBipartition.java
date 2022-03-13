package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        /*
        두 그룹으로 나눈다. 1 ~ N
        싫어하는 사람이 있다.

        싫어하는 사람들이 모이지 않도록 2 그룹으로 나눌수 있을까?
         */

        Map<Integer, Set<Integer>> personDislikeMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            personDislikeMap.put(i, new HashSet<>());
        }

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];

            personDislikeMap.get(a).add(b);
            personDislikeMap.get(b).add(a);
        }

        int[] group = new int[n + 1]; // -1, 0, 1 : -1그룹, 1그룹, 0은 아직 결정 안됨
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0 && !dfs(personDislikeMap, group, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, Set<Integer>> personDislikeMap, int[] group, int n, int g) {
        group[n] = g;

        Set<Integer> dislikeSet = personDislikeMap.get(n);

        for (Integer idx : dislikeSet) {
            if (group[idx] == g) { // 같은 그룹에 있으면 안됨
                return false;
            }
            if (group[idx] == 0 && !dfs(personDislikeMap, group, idx, -g)) { // 아직 결정 안되었으면 다른 그룹으로 매핑해서 탐색
                return false;
            }
        }

        return true;
    }
}
