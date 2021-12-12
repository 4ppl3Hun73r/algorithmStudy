package contest;

import java.util.Arrays;

public class Contest9 {
    public int countPoints(String rings) {
        char[] arr = rings.toCharArray();

        int[] rod = new int[10];
        for (int i = 0; i < arr.length; i+=2) {
            char color = arr[i];
            char pos = arr[i + 1];

            int bit = 0;
            if (color == 'R') {
                bit = 1;
            }
            if (color == 'G') {
                bit = 2;
            }
            if (color == 'B') {
                bit = 4;
            }

            rod[pos - '0'] |= bit;
        }

        System.out.println(Arrays.toString(rod));

        int rgb = 7;
        int cnt = 0;
        for (int i : rod) {
            if (i == rgb) {
                cnt ++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Contest9 c = new Contest9();
        System.out.println(c.countPoints("B7R5B3G5B1R2B8"));
    }
}
