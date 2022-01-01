package y2021.sep;

import java.util.*;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3972/
public class Solution0913 {
    class Node {
        int value;
        List<Edge> edges;
    }

    class Edge {
        Node target;
        int weight;
    }

    class History {
        Node start;
        Node end;
        int step;
        int originalWeight;
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // weight graph
        // 0에서 maxMoves이동했을때 방문할수 있는 모든 노드의 수
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].value = i;
            nodes[i].edges = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Edge e = new Edge();
            e.target = nodes[edge[1]];
            e.weight = edge[2];
            nodes[edge[0]].edges.add(e);

            e = new Edge();
            e.target = nodes[edge[0]];
            e.weight = edge[2];
            nodes[edge[1]].edges.add(e);
        }

        check = new boolean[n];
        history = new HashMap<>();
        dfs(nodes[0], maxMoves);

        // 1 --{4}-- 2
        // Pair(1,2)
        // History(1, 2, 1)
        // History(2, 1, 2)
        // History(2, 1, 3)
        // History(2, 1, 1)
        history.entrySet()
                .stream()
                .filter(pairListEntry -> pairListEntry.getValue().size() > 1)
                .forEach(pairListEntry -> {
                    Pair key = pairListEntry.getKey();
                    List<History> value = pairListEntry.getValue();

                    History left = value.stream()
                            .filter(h -> h.start.value == key.a)
                            .max((o1, o2) -> o1.step - o2.step)
                            .get();

                    History right = value.stream()
                            .filter(h -> h.start.value == key.b)
                            .max((o1, o2) -> o1.step - o2.step)
                            .get();

                    result += Math.min(left.step + right.step, left.originalWeight);
                    System.out.println("d result:[" + result + "]");
                });

        history.entrySet()
                .stream()
                .filter(pairListEntry -> pairListEntry.getValue().size() == 1)
                .map(pairListEntry -> pairListEntry.getValue().get(0))
                .forEach(history1 -> {
                    result += history1.step;
                });

        return result;
    }

    boolean[] check;
    int result = 0;

    class Pair {
        int a; int b;

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair)o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    Map<Pair, List<History>> history;

    // step: 남은 걸음 수
    void dfs(Node now, int step) {
        check[now.value] = true;

        for (Edge edge : now.edges) {
            if (edge.weight + 1 <= step) {
                // 방문한곳은 빼고?
                result += edge.weight + 1;

                // node 탐색
                if (check[edge.target.value] == false && edge.weight + 1 != step) {
                    dfs(edge.target, step - (edge.weight + 1));
                }
            } else {
                // start, end, weight
                // start, end, step
                // end, start, step
                Pair pair = new Pair();
                pair.a = Math.min(now.value, edge.target.value);
                pair.b = Math.max(now.value, edge.target.value);

                History h = new History();
                h.start = now;
                h.end = edge.target;
                h.step = step;
                h.originalWeight = edge.weight;

                if (history.containsKey(pair)) {
                    history.get(pair).add(h);
                } else {
                    List<History> value = new ArrayList<>();
                    value.add(h);
                    history.put(pair, value);
                }
            }
        }

        check[now.value] = false;
    }

    public static void main(String[] args) {
        Solution0913 s = new Solution0913();

        System.out.println(s.solution(new int[][]{{0,1,10}, {0,2,1}, {1,2,2}}, 6, 3));
        // 13
        System.out.println(s.solution(new int[][]{{0,1,4}, {1,2,6}, {0,2,8}, {1,3,1}}, 10, 4));
        // 23
        System.out.println(s.solution(new int[][]{{1,2,4}, {1,4,5}, {1,3,1}, {2,3,4}, {3,4,5}}, 17, 5));
        // 1
    }

    class ANode {
        int node, dist;
        ANode(int n, int d) {
            node = n;
            dist = d;
        }
    }

    public int solution(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, x->new HashMap()).put(v, w);
            graph.computeIfAbsent(v, x->new HashMap()).put(u, w);
        }

        PriorityQueue<ANode> pq = new PriorityQueue<ANode>(
                (a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new ANode(0, 0));

        Map<Integer, Integer> dist = new HashMap();
        dist.put(0, 0);
        Map<Integer, Integer> used = new HashMap();
        int ans = 0;

        while (!pq.isEmpty()) {
            ANode anode = pq.poll();
            int node = anode.node;
            int d = anode.dist;

            if (d > dist.getOrDefault(node, 0)) continue;
            // Each node is only visited once.  We've reached
            // a node in our original graph.
            ans++;

            if (!graph.containsKey(node)) continue;
            for (int nei: graph.get(node).keySet()) {
                // M - d is how much further we can walk from this node;
                // weight is how many new nodes there are on this edge.
                // v is the maximum utilization of this edge.
                int weight = graph.get(node).get(nei);
                int v = Math.min(weight, M - d);
                used.put(N * node + nei, v);

                // d2 is the total distance to reach 'nei' (neighbor) node
                // in the original graph.
                int d2 = d + weight + 1;
                if (d2 < dist.getOrDefault(nei, M+1)) {
                    pq.offer(new ANode(nei, d2));
                    dist.put(nei, d2);
                }
            }
        }

        // At the end, each edge (u, v, w) can be used with a maximum
        // of w new nodes: a max of used[u, v] nodes from one side,
        // and used[v, u] nodes from the other.
        // [We use the encoding (u, v) = u * N + v.]
        for (int[] edge: edges) {
            ans += Math.min(edge[2], used.getOrDefault(edge[0] * N + edge[1], 0) +
                    used.getOrDefault(edge[1] * N + edge[0], 0) );
        }

        return ans;
    }
}
