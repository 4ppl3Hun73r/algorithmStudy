package y2023.jan;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/number-of-good-paths/
public class Solution0115 {
    // https://leetcode.com/problems/number-of-good-paths/solutions/3014643/solution-with-union-find-for-tree-paths-with-constraints/?page=2
    int[] parents, count, vals;
    int res;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        this.vals = vals;
        int n = vals.length;
        Arrays.sort(edges, Comparator.comparingInt(a -> Math.max(vals[a[0]], vals[a[1]])));
        res = n;
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        count = new int[n];
        for(int[] edge: edges) {
            union(edge[0], edge[1]);
        }
        return res;
    }

    private void union(int a, int b) {
        int pa = parent(a);
        int pb = parent(b);
        if(pa == pb) {
            return ;
        }
        if(vals[pa] == vals[pb]) {
            res += (count[pa] + 1) * (count[pb] + 1);
            count[pa] += count[pb] + 1;
            parents[pb] = pa;
        }
        else if(vals[pa] > vals[pb]) {
            parents[pb] = pa;
        }
        else {
            parents[pa] = pb;
        }
    }

    private int parent(int a) {
        int p = parents[a];
        if (p != a) {
            return parents[a] = parent(p);
        }
        return p;
    }

    /* https://leetcode.com/problems/number-of-good-paths/solutions/2624705/java-diagram-union-find-explained/
    Time limit exceeded
    int[] parent;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        if (n == 1) {
            return 1;
        }
        List<Integer> ids = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            ids.add(i);
            parent[i] = i;
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Collections.sort(ids, Comparator.comparingInt(a -> vals[a]));

        int result = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while(j < n && vals[ids.get(j)] == vals[ids.get(i)]) {
                j++;
            }

            for (int k = 0; k < j; k++) {
                int x = ids.get(k);
                for(int neighbor : graph.get(x)){
                    if (vals[x] >= vals[neighbor]) {
                        // union node x and its smaller neighbor
                        parent[find(x)] = find(neighbor);
                    }
                }
            }

            Map<Integer, Integer> temp = new HashMap<>();
            for(int k = i; k < j; k++){
                int root = find(ids.get(k));
                temp.put(root, temp.getOrDefault(root, 0) + 1);
            }
            // standalone nodes are included. Note C(n, 2) + n = C(n + 1, 2)
            for (int v : temp.values()){
                result += v * (v + 1) / 2;
            }
            i = j - 1;
        }
        return result;
    }

    // find(x): 재귀 이용
    int find(int x) {
        // 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if (parent[x] == x) {
            return x;
        } else {
            // 각 노드의 부모 노드를 찾아 올라간다.
            return parent[x] = find(parent[x]);
        }
    }
    */
}
