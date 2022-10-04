package y2022.sep;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
public class Solution0926 {

    int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        /*
        들어오는 등식을 검증
        [a==b, a!=b] => false
        [a==b, b==a] => true

        [a==b, b==a, c==d, d==e, ....... z!=a, b==z]

        groupNo

        a,0
        b,0
        c,1
        d,1
        e,1
        z,2

        Map<char, set<char>>

        ["a!=a"]
         */

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            char[] equationArr = equation.toCharArray();

            char left = equationArr[0];
            char right = equationArr[3];
            char equal = equationArr[1];

            int leftNo = left - 'a';
            int rightNo = right - 'a';

            if (equal == '=') {
                union(leftNo, rightNo);
            }
        }

        for (String equation : equations) {
            char[] equationArr = equation.toCharArray();

            char left = equationArr[0];
            char right = equationArr[3];
            char equal = equationArr[1];

            int leftNo = left - 'a';
            int rightNo = right - 'a';

            if (equal == '!') {
                int leftGroupNo = find(leftNo);
                int rightGroupNo = find(rightNo);

                if (leftGroupNo == rightGroupNo) {
                    return false;
                }
            }
        }

        return true;
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
        Solution0926 s = new Solution0926();

        System.out.println(s.equationsPossible(new String[]{
                "b==d","c==a","h==a","d==d","a==b","h!=k","i==h"
        }));
        // C:1 , f:2, a:3, b:2
    }
}
