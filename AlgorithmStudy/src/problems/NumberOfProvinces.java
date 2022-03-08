package problems;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    int[] parent;

    public int findCircleNum(int[][] isConnected) {
        /*
        isConnected[i][j] is 1 or 0.
        isConnected[i][i] == 1
        isConnected[i][j] == isConnected[j][i]
        [[1,1,0]
        ,[1,1,0]
        ,[0,0,1]]

        [[1,0,0]
        ,[0,1,0]
        ,[0,0,1]]
         */
        int result = 0;
        int len = isConnected.length;
        parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> parentCnt = new HashSet<>();
        for (int i = 0; i < len; i++) {
            parentCnt.add(find(i));
        }

        return parentCnt.size();
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
