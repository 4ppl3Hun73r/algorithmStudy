package problems;

import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected {

    int[] parent;

    public int makeConnected(int n, int[][] connections) {
        /*
        n 개의 컴퓨터를 모두 연결 시켜라
        연결을 바꿀수 있음
        최소한의 연결 변경을 해야함
        모두 연결이 불가능 하면 -1 반환
         */
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int remainCable = 0;
        boolean[] connected = new boolean[n];
        for (int[] connection : connections) {
            int computer1 = connection[0];
            int computer2 = connection[1];
            union(computer1, computer2);

            if (connected[computer1] && connected[computer2]) {
                remainCable++;
            } else {
                connected[computer1] = true;
                connected[computer2] = true;
            }
        }

        Set<Integer> networkGroupSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            networkGroupSet.add(find(i));
        }

        int needCable = networkGroupSet.size();

        return needCable > remainCable ? -1 : needCable;

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
