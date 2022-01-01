package y2021.oct;

// https://leetcode.com/problems/guess-number-higher-or-lower/
public class Solution1012 extends GuessGame {
    public Solution1012(int num) {
        super(num);
    }

    public int guessNumber(int n) {
        // 어떻게 접근할까요?
        // 1 <= pick <= n <= 2^31 - 1

        // brute force
        bruteForce(n);

        // binary search
        long start = 1;
        long end = n;
        while (start <= end) {
            int mid = (int)((start + end) / 2);
            // System.out.println(mid);
            // System.out.println(start + ((end - start) / 2));
            // start + ((end - start) / 2) == (start + end) / 2 ???
            // start + end/2 - start/2 = start/2 + end/2
            // System.out.println(mid);
            int upOrDown = guess(mid);

            // S----------M----------E
            //          P, upOrDown = -1
            // S----M-----E
            //      S  M  E , upOrDown = 1

            if (upOrDown > 0) {
                start = mid + 1;
            } else if (upOrDown < 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return n;
    }

    private int bruteForce(int n) {
        for (int i = 0; i <= n; i++) {
            if (guess(n) == 0) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        Solution1012 s = new Solution1012(1702766719);

        System.out.println(s.guessNumber(2126753390));
    }

}

class GuessGame {
    int pick;

    public GuessGame(int num) {
        this.pick = num;
    }

    // pre-defined
    int guess(int num) {
        return Integer.compare(this.pick, num);
    }

}