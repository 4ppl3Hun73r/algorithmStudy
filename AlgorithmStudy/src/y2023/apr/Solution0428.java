package y2023.apr;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/similar-string-groups/
public class Solution0428 {

    int[] parent;

    public int numSimilarGroups(String[] strs) {
        /*
        비슷한 단어 들을 그룹화 하기

        1. 비슷한 단어 찾기
          - char 를 한번만 swap 했을때 같으면 비슷한건데
        2. 그룹화하기
          - arts <1> rats -> 비슷한 단어
          - tars <1> rats -> 비슷한 단어
          - tars <2> arts -> 이건 아님
          - group1 : tars, arts, tars
         */
        int n = strs.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isEqual(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }

        /*
         [1,1,1,1,2,2,2,2,3,3,3] => 한그룹
         [1,1,1,1,1,1,1,1,1,1,1]
         */

        Set<Integer> groupCount = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groupCount.add(find(i));
        }

        return groupCount.size();
    }

    private boolean isEqual(String s1, String s2) {
        /*
          s1, s2 는 길이가 같고, 안에 포함된 char의 종류와 수가 같다.
          All words in strs have the same length and are anagrams of each other.
         */
        int n = s1.length();

        // arts
        // rats
        // ++== => 2
        /*
        tars
        rats
        +=+= => 2

        tars
        arts
        +++= => 3
         */
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return diff != 1;
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
