package problems;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // 그래프에서 모든 그래프를 순회할수 있게 할수 있는 edge 목록 반환
        // 걍 방문하는 애가 없으면 정답?
        boolean[] candidate = new boolean[n];

        for (List<Integer> edge : edges) {
            candidate[edge.get(1)] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < candidate.length; i++) {
            if (!candidate[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
