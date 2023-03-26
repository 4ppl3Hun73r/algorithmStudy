package y2023.mar;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
public class Solution0325 {

    int[] parent;

    /* find(x): 재귀 이용 */
    int find(int x) {
        // 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if (parent[x] == x) {
            return x;
        } else {
            // 각 노드의 부모 노드를 찾아 올라간다.
            return parent[x] = find(parent[x]);
        }
    }

    /* union(x, y) */
    void union(int x, int y){
        // 각 원소가 속한 트리의 루트 노드를 찾는다.
        x = find(x);
        y = find(y);

        parent[y] = x;
    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Map<Integer, Long> groupCntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int group = find(i);
            groupCntMap.put(group, groupCntMap.getOrDefault(group, 0L) + 1L);
        }

        long ans = 0;
        long otherNodes = n;
        for (Long cnt : groupCntMap.values()) {
            otherNodes -= cnt;
            ans += cnt * otherNodes;
        }

        return ans;

    }

    public static void main(String[] args) {
        Solution0325 s = new Solution0325();

        /*System.out.println(s.countPairs(7, new int[][]{
                {0,2}, {0,5}, {2,4}, {1,6}, {4,5}

        }));*/

        System.out.println(s.countPairs(100000, new int[][]{}));
    }
}
