package contest;

public class Contest42 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        /*
        hidden = lower ~ upper
        differences[i] = hidden[i + 1] - hidden[i]
        differences[i + 1] = hidden[i + 2] - hidden[i + 1]

        differences[i] = hidden[i + 1] - hidden[i]
        hidden[i] = hidden[i + 1] - diff[i]
        hidden[i + 1] = hidden[i + 2] - diff[i + 1]
        hidden[i] = hidden[i + 2] - diff[i] - diff[i + 1]
        hidden[last] = hidden[last - 1] - (diff[i] + .. .diff[last - 1])

        lower <= diff[i] - diff[i + 1] <= upper

        f(x) = f(x + 1) - 상수


        [1, -3, 4], 1 ~ 6
        [4 ,5  ,2, 6]

        [1, 4, -3], 1 ~ 6
         */

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int diff = 0;
        for (int i = 0; i < differences.length; ++i) {
            diff += differences[i];
            min = Math.min(min, diff);
            max = Math.max(max, diff);
        }

        int result = 0;
        for (int i = lower; i <= upper; i++) {
            int low = i + min;
            int high = i + max;
            if (low >= lower && high <= upper) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Contest42 c = new Contest42();

        for (int i = 0; i < 100000; i++) {
            System.out.printf("%d,", i);
        }

    }
}
