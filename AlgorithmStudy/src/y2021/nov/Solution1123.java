package y2021.nov;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/largest-component-size-by-common-factor/
public class Solution1123 {

    int[] parent;

    public int largestComponentSize(int[] nums) {
        // 1 <= nums.len <= 20000
        // 1 <=nums[i] <= 100000
        // 소인수를 이용한 Union Find?
        // 소인수 같은 걸 묶는거

        /*
        https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
        index 값과 배열안에 값을 둘다 생각하면 된다.
         [0,1,2,3,4,5]
         [0,1,1,2,4,5]
         */
        parent = new int[nums.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // nums에 소인수 값들을 이용해서 union 시키기
        Map<Integer, Integer> factorMap = new HashMap<>();
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for(int j = 2; j * j <= n; j++) {	// 또는 i * i <= N
                if (n % j == 0) {
                    // 소인수 이면 확인
                    // 4,6,15,35
                    // 6 -> 1, 2 * 3 6 /2 => 3
                    /*
                    <2, 0>
                    <4, 0>
                    union(0, 1); [0, 0]
                    <3, 1>
                    <6, 1>
                    union(1, 2);
                    <5, 2>
                    <15, 2>
                    union(2, 3);
                     */
                    if (factorMap.containsKey(j)) { // num 6 j = 2,
                        union(i, factorMap.get(j));
                        //System.out.println(factorMap);
                        //System.out.println(Arrays.toString(parent));
                    } else {
                        factorMap.put(j, i);
                    }
                    int factor = n / j;
                    if (factorMap.containsKey(factor)) {
                        union(i, factorMap.get(factor));
                        //System.out.println(factorMap);
                        //System.out.println(Arrays.toString(parent));
                    } else {
                        factorMap.put(factor, i);
                    }
                }
            }
            if (factorMap.containsKey(n)) {
                union(i, factorMap.get(n));
                //System.out.println(factorMap);
                //System.out.println(Arrays.toString(parent));
            } else {
                factorMap.put(n, i);
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = find(i);
            int count = countMap.getOrDefault(x, 0);
            count++;
            countMap.put(x, count);
            max = Math.max(max, count);
        }
        // System.out.println(Arrays.toString(parent));

        return max;
    }

    int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
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

    public static void main(String[] args) throws Exception {
        Solution1123 s = new Solution1123();
        System.out.println(s.largestComponentSize(new int[]{4,6,15,35}));
        System.out.println(s.largestComponentSize(new int[]{20,50,9,63}));
        System.out.println(s.largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));

        int[] test = new int[20000];
        for (int i = 1; i <= test.length; i++) {
            test[i - 1] = i;
        }
        //System.out.println(Arrays.toString(test));
        System.out.println(s.largestComponentSize(test)); // 17741, 18966

    }
}
