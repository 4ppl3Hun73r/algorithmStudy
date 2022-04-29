package y2022.apr;

import java.util.*;

// https://leetcode.com/problems/smallest-string-with-swaps/
public class Solution0427 {

    int[] parent;
    int[] size;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        parent = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            int idx1 = pair.get(0);
            int idx2 = pair.get(1);

            union(idx1, idx2);
        }

        // 리스트 합치기
        Map<Integer, PriorityQueue<Character>> indexCharMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int p = find(i);
            PriorityQueue<Character> pq = indexCharMap.getOrDefault(p, new PriorityQueue<>());
            pq.add(s.charAt(i));
            indexCharMap.putIfAbsent(p, pq);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(indexCharMap.get(find(i)).poll());
        }

        return sb.toString();
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (size[pa] > size[pb])
                parent[pb] = pa;
            else if (size[pb] > size[pa])
                parent[pa] = pb;
            else {
                parent[pb] = pa;
                size[pa]++;
            }
        }
    }

    private int find(int a) {
        if (parent[a] == a)
            return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }



    public static void main(String[] args) throws Exception {
        Solution0427 s = new Solution0427();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));

        System.out.println(s.smallestStringWithSwaps("dcab", pairs));
    }
}
