package problems;

import java.util.Arrays;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;

        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char secretCh = secret.charAt(i);
            char guessCh = guess.charAt(i);

            if (secretCh == guessCh) {
                a++;
            } else {
                secretMap[secretCh - '0'] ++;
                guessMap[guessCh - '0'] ++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (secretMap[i] != 0 && guessMap[i] != 0) {
                b += Math.min(secretMap[i], guessMap[i]);
            }
        }
        System.out.println(Arrays.toString(secretMap));
        System.out.println(Arrays.toString(guessMap));

        return String.format("%dA%dB", a, b);
    }

    public static void main(String[] args) {
        BullsAndCows b = new BullsAndCows();
        System.out.println(b.getHint("12901943890127907132313213412", "91829034218409128391283091412"));
    }
}
