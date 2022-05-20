package y2022.may;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/critical-connections-in-a-network/
public class Solution0518 {

    int cnt = 1;
    Stack<int[]> stack = new Stack<>();
    Stack<Stack<int[]>> bcc = new Stack<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // https://anz1217.tistory.com/46
        // BCC : bi connection component
        /*
        connections[i] = [a, b]
        a != b

        connections 중에 하나를 제거 했을떄 서버들간의 연결이 끊기는 연결들을 찾기

            0
           / \
      4-  2 - 1 - 3
         [[1,3],[2,4]]

        n - 1 <= connections.length <= 100000
        */
        List<Integer>[] nodeConnectionMap = new List[n];
        for (int i = 0; i < n; i++) {
            nodeConnectionMap[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            nodeConnectionMap[a].add(b);
            nodeConnectionMap[b].add(a);
        }

        int[] visited = new int[n];
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, nodeConnectionMap, visited, min);
            }
        }

        /*System.out.println(bcc);
        while (!bcc.isEmpty()) {
            //System.out.println(bcc.peek());
            Stack<int[]> s = bcc.pop();
            while (!s.isEmpty()) {
                System.out.print("[" + s.peek()[0] + ", " + s.pop()[1] + "],");
            }
            System.out.println();
        }*/

        List<List<Integer>> ans = new ArrayList<>();
        while (!bcc.isEmpty()) {
            Stack<int[]> s = bcc.pop();
            if (s.size() == 1) {
                ans.add(List.of(s.peek()[0], s.pop()[1]));
            }
        }
        return ans;
    }

    private void dfs(int v, int p, List<Integer>[] nodeConnectionMap, int[] visited, int[] min) {
        // v 를 정점으로 가지는 서브 트리를 찾아서 묶어 준다.
        visited[v] = min[v] = cnt++;

        for (Integer node : nodeConnectionMap[v]) {
            if (node == p) {
                //???
                continue;
            }

            if (visited[v] > visited[node]) {
                stack.push(new int[]{v, node});
            }

            if (visited[node] != 0) {
                // 역방향
                min[v] = Math.min(min[v], visited[node]);
            } else {
                dfs(node, v, nodeConnectionMap, visited, min);
                min[v] = Math.min(min[v], min[node]);
                if (min[node] >= visited[v]) {
                    bcc.push(new Stack<>());
                    while (true) {
                        int[] e = stack.pop();
                        bcc.peek().push(e);

                        if (e[0] == v && e[1] == node) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution0518 s = new Solution0518();

        List<List<Integer>> connections = new ArrayList<>();

        connections.add(List.of(0,1));
        connections.add(List.of(1,2));
        connections.add(List.of(2,0));
        connections.add(List.of(1,3));
        connections.add(List.of(3,4));

        System.out.println(s.criticalConnections(5, connections));
    }


}
