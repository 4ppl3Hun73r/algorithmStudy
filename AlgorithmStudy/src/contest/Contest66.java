package contest;

public class Contest66 {
    public long[] sumOfThree(long num) {
        /*

        a + b + c = x

        b = a + 1
        c = a + 2

        3a + 3 = x
        3a = x - 3
        a = x/3 - 1
         */
        if (num % 3 != 0) {
            return new long[0];
        }
        long[] res = new long[3];
        res[0] = num / 3 - 1;
        res[1] = res[0];
        res[2] = res[0] + 2;

        return  res;

        /*
        11 12 13 -> 36
        12 13 14 -> 39
         */

    }

    public static void main(String[] args) {
        Contest66 c = new Contest66();

    }
}
