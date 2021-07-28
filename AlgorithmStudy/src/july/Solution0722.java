package july;

public class Solution0722 {


    public String pushDominoes(String dominoes) {
        char[] result = dominoes.toCharArray();

        char before = '?';
        int rIndex = 0;
        int dotCount = 0;
        int lIndex = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == '.') {
                dotCount++;
                if (before == '?' || before == '.') {
                    result[i] = '.';
                    continue;
                } else if (before == 'R'){
                    result[i] = before;
                }
            } else if (c == 'R') {
                result[i] = 'R';
                rIndex = i;
                dotCount = 0;
            } else {
                result[i] = 'L';

                if(before == 'R') {
                    int center = dotCount / 2;
                    for (int k = 1; k < center; k++) {
                        result[i - k] = 'L';
                    }
                    if (dotCount % 2 == 1) {
                        result[center + rIndex] = '.';
                    }
                } else {
                    int k = i - 1;
                    while (k >= 0 && dominoes.charAt(k) == '.') {
                        result[k--] = 'L';
                    }
                }
            }
            before = result[i];
        }

        return String.valueOf(result);

    }

    // Approach #1: Adjacent Symbols [Accepted]
    public String pushDominoes2_solution(String dominoes) {
        int N = dominoes.length();
        int[] indexes = new int[N+2];
        char[] symbols = new char[N+2];
        int len = 1;
        indexes[0] = -1;
        symbols[0] = 'L';

        for (int i = 0; i < N; ++i)
            if (dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len++] = dominoes.charAt(i);
            }

        indexes[len] = N;
        symbols[len++] = 'R';

        char[] ans = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int i = indexes[index], j = indexes[index+1];
            char x = symbols[index], y = symbols[index+1];
            char write;
            if (x == y) {
                for (int k = i+1; k < j; ++k)
                    ans[k] = x;
            } else if (x > y) { // RL
                for (int k = i+1; k < j; ++k)
                    ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
            }
        }

        return String.valueOf(ans);
    }

   // Approach #2: Calculate Force [Accepted]
    class Solution {
        public String pushDominoes(String S) {
            char[] A = S.toCharArray();
            int N = A.length;
            int[] forces = new int[N];

            // Populate forces going from left to right
            int force = 0;
            for (int i = 0; i < N; ++i) {
                if (A[i] == 'R') force = N;
                else if (A[i] == 'L') force = 0;
                else force = Math.max(force - 1, 0);
                forces[i] += force;
            }

            // Populate forces going from right to left
            force = 0;
            for (int i = N-1; i >= 0; --i) {
                if (A[i] == 'L') force = N;
                else if (A[i] == 'R') force = 0;
                else force = Math.max(force - 1, 0);
                forces[i] -= force;
            }

            StringBuilder ans = new StringBuilder();
            for (int f: forces)
                ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
            return ans.toString();
        }
    }
}