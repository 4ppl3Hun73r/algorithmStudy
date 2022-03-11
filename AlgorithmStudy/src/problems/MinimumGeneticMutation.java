package problems;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {

        /*
        start -> end 로 가야함 최소한의 변경으로

        bank 에 있어야 중간에 스텝으로 갈수 있음
         */
        Map<String, Set<Integer>> bankMutationMap = new HashMap<>();
        int endIdx = -1;
        List<String> geneList = new ArrayList<>();
        geneList.add(start);
        for (String gene : bank) {
            geneList.add(gene);
        }
        for (int i = 0; i < geneList.size(); i++) {
            bankMutationMap.put(geneList.get(i), new HashSet<>());
            if (end.equals(geneList.get(i))) {
                endIdx = i;
            }
        }
        if (endIdx == -1) {
            return -1;
        }

        for (int i = 0; i < geneList.size(); i++) {
            String gene1 = geneList.get(i);
            for (int j = i + 1; j < geneList.size(); j++) {
                int diff = 0;
                String gene2 = geneList.get(j);
                for (int k = 0; k < 8; k++) {
                    if (gene1.charAt(k) != gene2.charAt(k)) {
                        diff ++;
                        if (diff == 2) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    bankMutationMap.get(gene1).add(j);
                    bankMutationMap.get(gene2).add(i);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[geneList.size()];
        queue.add(0);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step ++;
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                visited[idx] = true;
                if (idx == endIdx) {
                    return step;
                }

                for (Integer nextIdx : bankMutationMap.get(geneList.get(idx))) {
                    if (!visited[nextIdx]) {
                        queue.add(nextIdx);
                    }
                }
            }
        }

        return -1;

    }
}
