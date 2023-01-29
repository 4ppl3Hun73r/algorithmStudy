package y2023.jan;

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
public class Solution0114 {

    int[] parent = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
       /*
       s1 [abc]
       s2 [cde]
        a == c == e
        b == d
       baseStr [eed]
       e -> a
       aab
        */

       int n = s1.length();

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char)(find(c - 'a') + 'a'));
        }

        return sb.toString();

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

        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        parent[y] = x;
    }
}
