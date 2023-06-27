package y2023.mar;

public class Solution0322 {

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

    public int minScore(int n, int[][] roads) {
        // 1 -> n 까지 가는 길 중에 가장 적은 score 를 찾아라
        // union find 를 이용해서 1과 연결된 도로를 하나로 합쳐나감
        // 최종적으로 1그룹과 N 만 남기기
        int ans = Integer.MAX_VALUE;

        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] road : roads) {
            // 길 합치기
            union(road[0], road[1]);
        }

        for (int[] road : roads) {
            // 1 과 같은 그룹이면 가장 작은 이동 값으로 연결 가능
            // 1 과 N 은 무조건 같은 그룹인게 보장되기 때문에 최종적으로 같은 그룹에서 최소값이 답이 됨
            if (find(1) == find(road[0])) {
                ans = Math.min(ans, road[2]);
            }
        }

        return ans;
    }
}
