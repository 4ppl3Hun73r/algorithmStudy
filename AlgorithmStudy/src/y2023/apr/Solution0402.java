package y2023.apr;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
public class Solution0402 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        /*
        spells[i] * potions[all] => [count > success, ... ]

         */
        int n = spells.length;
        int m = potions.length;

        // spell 도 정렬해야 하는데 답을 위해서  index 보관 처리
        int[][] sortedSpells = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }

        Arrays.sort(sortedSpells, Comparator.comparingInt(a -> a[0]));
        // System.out.println(Arrays.deepToString(sortedSpells));
        Arrays.sort(potions);

        int[] answer = new int[n];
        int potionIndex = m - 1; // 마지막 위치
        for (int[] sortedSpell : sortedSpells) {
            int spell = sortedSpell[0];
            int index = sortedSpell[1];

            // 작은 수 나올때까지 계산
            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
                potionIndex -= 1;
            }
            answer[index] = m - (potionIndex + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution0402 s = new Solution0402();

        s.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7);
    }
}
