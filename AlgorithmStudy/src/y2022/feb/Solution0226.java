package y2022.feb;

import java.util.*;

public class Solution0226 {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;

        if (len == 1) {
            return 0;
        }

        Map<Integer, Set<Integer>> nodeVisitedSet = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int visited = 1 << i;
            queue.add(new Node(i, visited));
            nodeVisitedSet.put(i, new HashSet<>());
        }

        int ans = 0;
        int findVisitedMask = (1 << len) - 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans ++;
            System.out.println(size);
            for (int j = 0; j < size; j++) {
                Node node = queue.poll();
                // 방문하지 않은 곳으로 방문 처리
                // 방문하지 않은 곳이 남았는데 갈곳이 없으면 뒤로 돌아가기
                //System.out.println(node.unVisitedNodeCnt);
                //System.out.println(Arrays.toString(node.visited));
                int[] g = graph[node.n];
                for (int i = 0; i < g.length; i++) {
                    int nextNode = g[i];
                    int newVisited = node.visited | (1 << nextNode);
                    if (newVisited == findVisitedMask) {
                        return ans;
                    }
                    if (nodeVisitedSet.get(nextNode).contains(newVisited)) {
                        continue;
                    }
                    nodeVisitedSet.get(nextNode).add(newVisited);
                    queue.add(new Node(nextNode, newVisited));
                }
            }
        }

        return ans;
    }

    class Node {
        int n;
        int visited;

        public Node(int n, int visited) {
            this.n = n;
            this.visited = visited;
        }

    }

    public static void main(String[] args) {
        Solution0226 s = new Solution0226();

        System.out.println(s.shortestPathLength(new int[][]{
                {1,2,3},
                {0},
                {0},
                {0}
        }));

        System.out.println(s.shortestPathLength(new int[][]{
                {1},
                {0,2,4},
                {1,3,4},
                {2},
                {1,2}
        }));

        System.out.println(s.shortestPathLength(new int[][]{
                {1,2,3,4,5,6,7,8,9,10,11},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0},
                {0}
        }));



        //[[1,2,3,4,5,6,7,8,9,10,11],[0],[0],[0],[0],[0],[0],[0],[0],[0],[0],[0]]
    }
}
