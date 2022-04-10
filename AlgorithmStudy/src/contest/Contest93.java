package contest;

import java.util.Collections;
import java.util.PriorityQueue;

public class Contest93 {

    public int largestInteger(int num) {
        char[] numChar = String.valueOf(num).toCharArray();

        PriorityQueue<Integer> oddQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> evenQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < numChar.length; i++) {
            int n = numChar[i] - '0';

            if (n % 2 == 0) {
                evenQueue.add(n);
            } else {
                oddQueue.add(n);
            }
        }

        for (int i = 0; i < numChar.length; i++) {
            int n = numChar[i] - '0';

            if (n % 2 == 0) {
                numChar[i] = (char)(evenQueue.poll() + '0');
            } else {
                numChar[i] = (char)(oddQueue.poll() + '0');
            }
        }

        return Integer.parseInt(new String(numChar));

    }


    public static void main(String[] args) {
        Contest93 c = new Contest93();

        c.largestInteger(247);

    }
}
