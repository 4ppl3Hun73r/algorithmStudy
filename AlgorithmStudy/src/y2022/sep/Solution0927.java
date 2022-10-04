package y2022.sep;

// https://leetcode.com/problems/push-dominoes/
public class Solution0927 {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        int[] forces = new int[len];
        int force = 0;

        for (int i = 0; i < len; i++) {
            char domino = dominoes.charAt(i);
            if (domino == 'R') {
                force = len;
            } else if (domino == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] = force;
        }

        for (int i = len - 1; i >=0 ; i--) {
            char domino = dominoes.charAt(i);
            if (domino == 'L') {
                force = len;
            } else if (domino == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(forces[i] > 0 ? 'R' : forces[i] < 0 ? 'L' : '.');
        }

        return sb.toString();
    }
}
