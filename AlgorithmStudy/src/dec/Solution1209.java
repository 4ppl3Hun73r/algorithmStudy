package dec;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1209 {
    int step = 0;
    public boolean canReachDFS(int[] arr, int start) {
        // 시작 -> arr[i] == 0 을 갈수 있으면 true / false
        // start = i + arr[i] or start = i - arr[i];
        // dfs , bfs
        step++;
        if (arr[start] == 0) {
            System.out.println(step);
            step = 0;
            return true;
        }
        if (arr[start] < 0) {
            return false;
        }
        //System.out.println(arr[start]);
        int left = start + arr[start];
        int right = start - arr[start];
        arr[start] = -1;

        if (left < arr.length && canReachDFS(arr, left)) {
            return true;
        }
        if (right > -1 && canReachDFS(arr, right)) {
            return true;
        }
        return false;
    }

    public boolean canReachBFS(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        // DFS : 5 4 8 27 -> 탐색을 다 끝내고 다음 탐색
        // BFS : 6 4 1 38 -> 탐색을 왔다 갔다 하니까.. 좀 느릴수 있음
        /*
        DFS , BFS는 그래프 탐색 알고리즘
        Tree 도 Graph 한 계열이니까.
        Graph ->
        1 -> 2 -> 3 -> 4
                    -> 5 -> 0
                    4
                 /     \
                2       9
              /   \       \
            3      5       7
         */
        int step = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            step++;
            if (arr[idx] == 0) {
                System.out.println(step);
                return true;
            }

            int left = idx + arr[idx];
            int right = idx - arr[idx];
            arr[idx] = -1;

            if (left < arr.length && arr[left] >= 0) {
                queue.add(left);
            }
            if (right > -1 && arr[right] >= 0) {
                queue.add(right);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Solution1209 s = new Solution1209();
        System.out.println(s.canReachDFS(new int[]{4,2,3,0,3,1,2}, 5)); // true
        System.out.println(s.canReachDFS(new int[]{4,2,3,0,3,1,2}, 0)); // true
        System.out.println(s.canReachDFS(new int[]{3,0,2,1,2}, 2)); // false
        System.out.println(s.canReachDFS(new int[]{0}, 0)); // true
        System.out.println(s.canReachDFS(new int[]{47,26,216,78,179,101,42,233,185,56,303,310,169,338,51,104,308,162,81,82,169,41,106,150,285,298,33,251,289,236,256,227,197,186,267,326,268,243,89,347,72,0,89,157,90,333,327,76,106,68,355,124,234,70,43,248,259,280,199,201,312,327,217,278,330,258,348,351,223,240,143,244,64,343,339,101,193,18,140,312,71,225,111,79,199,226,321,344,31,177,362,115,341,79,146,303,348,291,250,169,78,307,325,33,338,316,201,343,37,37,0,15,341,38,44,67,280,128,31,106,220,172,349,142,339,181,102,351,81,209,41,181,59,216,230,170,257,52,5,338,28,75,208,307,108,103,34,342,82,233,263,12,167,358,316,150,337,158,78,231,26,22,147,81,12,319,161,12,75,129,54,119,131,334,292,253,255,98,39,67,146,15,329,120,80,347,89,124,303,315,235,55,1,100,290,187,333,326,87,138,48,41,153,118,192,152,279,69,154,71,152,273,61,153,267,51,106,225,204,327,50,15,202,244,328,3,150,355,240,240,188,92,107,244,280,102,265,273,328,115,70,221,357,101,186,251,116,24,125,58,185,34,356,21,108,221,169,208,230,226,235,336,304,315,334,329,229,190,20,104,348,132,66,265,55,212,102,167,52,2,328,114,101,196,99,155,158,337,191,119,14,347,127,305,142,156,92,340,358,58,7,178,79,355,289,199,251,233,351,57,115,306,179,31,42,123,87,101,218,71,193,205,300,180,42,19,280,233,293,181,147,359,190,168,191,5,58,198,154,139,29,342,261,245,141,26,251,162,360,219,233,297,287,262,112,87,261,21,205,131,98,161,103,57}, 313)); // true

    }
}
