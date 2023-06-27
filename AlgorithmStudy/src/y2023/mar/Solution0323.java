package y2023.mar;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class Solution0323 {

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

    public int makeConnected(int n, int[][] connections) {
        /*
        n 개의 컴퓨터를 모두 연결 시켜라
        연결을 바꿀수 있음
        최소한의 연결 변경을 해야함
        모두 연결이 불가능 하면 -1 반환

        케이블 수는 고정이고, 케이블 수로 다 연결해야 한다.
         */
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        /*
           0 - 1
           | /
           2   3

          (0 - 1)
           |                /
           2   3


         0 - 1
         |
         2 - 3 - 4

         */

        int remainCable = 0;
        for (int[] connection : connections) {
            int com1 = find(connection[0]);
            int com2 = find(connection[1]);

            if (com1 == com2) {
                // 이미 같은 그룹이니까 케이블 반납
                remainCable++;
            } else {
                // 같은 그룹으로 묶기
                union(connection[0], connection[1]);
            }
        }

        Set<Integer> groupCnt = new HashSet<>();
        // [0,0,0,3]
        for (int i = 0; i < n; i++) {
            groupCnt.add(find(parent[i]));
        }

        return (groupCnt.size() - 1) <= remainCable ? (groupCnt.size() - 1) : -1;

    }

    public static void main(String[] args) throws Exception {
        Solution0323 s = new Solution0323();

        System.out.println(s.makeConnected(5, new int[][]{
                {0,1},{0,2}, {3,4},{2,3}
        }));
    }

}
