package y2022.dec;

// https://leetcode.com/problems/find-if-path-exists-in-graph/
public class Solution1219 {

    int[] parent;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        /*
        source -> desc 까지 갈 수 있으면 true 없으면 false

         */
        parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return find(source) == find(destination);
    }


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
}
