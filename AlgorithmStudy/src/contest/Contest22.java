package contest;

import java.util.Arrays;

public class Contest22 {
    public int[] executeInstructions(int n, int[] startPos, String s) {

        int len = s.length();
        int[] result = new int[len];
        int[] pos = new int[2];
        for (int i = 0; i < len; i++) {
            pos[0] = startPos[0];
            pos[1] = startPos[1];
            int j = i;
            for (; j < len; j++) {
                char o = s.charAt(j);
                if (o == 'L') {
                    pos[1]--;
                } else if (o == 'R') {
                    pos[1]++;
                } else if (o == 'U') {
                    pos[0]--;
                } else if (o == 'D') {
                    pos[0]++;
                }

                if (pos[0] < 0 || pos[0] == n || pos[1] < 0 || pos[1] == n) {
                    break;
                }
            }
            result[i] = j;
        }
// LRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDLRUDDDDDDDDDDDDUUUUDUDUDUDUDUDUDUDUDUUUUUUUUUDDDUDDUDUDULLLLLLRRRRLRLRLRLRLRLRLUUUDUDUDUDUDUDUDULLLUDUDUDUD
        return result;
    }

    public static void main(String[] args) {
        Contest22 c = new Contest22();

        System.out.println(Arrays.toString(c.executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
    }
}
