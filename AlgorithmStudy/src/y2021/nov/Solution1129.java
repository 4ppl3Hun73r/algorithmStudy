package y2021.nov;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/
public class Solution1129 {
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        // 이름 - 이메일 목록
        // 이메일이 같으면 하나로 머지 (이메일은 sorted 되야함)
        // DFS, BFS, Union Find
        /*
        [
        0: ["John","johnsmith@mail.com","john_newyork@mail.com"],
        1: ["John","johnsmith@mail.com","john00@mail.com"]
        2: ["Mary","mary@mail.com"]
        3: ["John","johnnybravo@mail.com"]]

        parent: [0,1,2,3]
        [1,1,2,3]
         */
        parent = new int[accounts.size()];
        Map<String, Integer> emailIndexMap = new HashMap<>();
        Map<Integer, Set<String>> indexEmailSetMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            parent[i] = i;
            List<String> emailList = accounts.get(i);
            Set<String> emailSet = new TreeSet<>();
            for (int j = 1; j < emailList.size(); j++) {
                String email = emailList.get(j);
                if (emailIndexMap.containsKey(email)) {
                    union(i, emailIndexMap.get(email));
                } else {
                    emailIndexMap.put(email, i);
                }
                emailSet.add(email);
            }
            // {0, 0 list}
            indexEmailSetMap.put(i, emailSet);
        }
        System.out.println(Arrays.toString(parent));

        for (int i = 0; i < parent.length; i++) {
            int parent = find(i);
            if (parent != i) {
                indexEmailSetMap.get(parent).addAll(indexEmailSetMap.remove(i));
            }
        }

        for (Integer i : indexEmailSetMap.keySet()) {
            List<String> subResult = new ArrayList<>(indexEmailSetMap.get(i));
            Collections.sort(subResult);
            subResult.add(0, accounts.get(i).get(0));
            result.add(subResult);
        }

        return result;
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
        Solution1129 s = new Solution1129();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(s.accountsMerge(accounts));
    }
}


