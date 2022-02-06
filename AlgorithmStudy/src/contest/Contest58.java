package contest;

import java.util.Arrays;

public class Contest58 {
    public long smallestNumber(long num) {
        boolean minus = num < 0;


        char[] n = Long.toString(num).toCharArray();
        Arrays.sort(n);

        if (minus) {
            StringBuilder sb = new StringBuilder();
            for (int i = n.length - 1; i >= 1; i--) {
                sb.append(n[i]);
            }
            return -Long.parseLong(sb.toString());
        }

        if (n[0] == '0') {
            int i = 1;
            while (i != n.length && n[i] == '0') {
                i++;
            }
            if (i != n.length) {
                n[0] = n[i];
                n[i] = '0';
            }
        }

        return Long.parseLong(new String(n));
    }

    public static void main(String[] args) {
        Contest58 c = new Contest58();
        System.out.println(c.smallestNumber(0));
        System.out.println(c.smallestNumber(1));
        System.out.println(c.smallestNumber(10));
        System.out.println(c.smallestNumber(101));

    }
}
