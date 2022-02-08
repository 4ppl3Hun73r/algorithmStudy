package y2022.feb;

// https://leetcode.com/problems/add-digits/
public class Solution0208 {
    public int addDigits(int num) {
        /*
        0 - 0 10 - 1 20 - 2 30 - 3 40 - 4 50 - 5 60 - 6 70 - 7 100 - 1 110 - 2
        1 - 1 11 - 2 21 - 3 31 - 4 41 - 5 51 - 6 61 - 7 71 - 8 101 - 2 111 - 3
        2 - 2 12 - 3 22 - 4 32 - 5 42 - 6 52 - 7 62 - 8 72 - 9 102 - 3 112 - 4
        3 - 3 13 - 4 23 - 5 33 - 6 43 - 7 53 - 8 63 - 9 73 - 1 103 - 4 113 - 5
        4 - 4 14 - 5 24 - 6 34 - 7 44 - 8 54 - 9 64 - 1 74 - 2 104 - 5 114 - 6
        5 - 5 15 - 6 25 - 7 35 - 8 45 - 9 55 - 1 65 - 2 75 - 3 105 - 6 115 - 7
        6 - 6 16 - 7 26 - 8 36 - 9 46 - 1 56 - 2 66 - 3 76 - 4 106 - 7 116 - 8
        7 - 7 17 - 8 27 - 9 37 - 1 47 - 2 57 - 3 67 - 4 77 - 5 107 - 8 117 - 9
        8 - 8 18 - 9 28 - 1 38 - 2 48 - 3 58 - 4 68 - 5 78 - 6 108 - 9 118 - 1
        9 - 9 19 - 1 29 - 2 39 - 3 49 - 4 59 - 5 69 - 6 79 - 7 109 - 1 119 - 2
         */
        /*

        1235
        1000
        1 234567890 234567890 234567890
        1235%9 = 2
        2
        384568721

        342
         */

        if (num == 0) {
            return 0;
        }
        int m = num%9;
        if (m == 0) {
            return 9;
        }
        return m;
    }

    public int addDigits2(int num) {
        while (num >= 10) {
            int t = 0;
            while (num != 0) {
                t += num % 10;
                num = num / 10;
            }
            num = t;
        }

        return num;
    }

    public static void main(String[] args) throws Exception {
        Solution0208 s = new Solution0208();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //System.out.println(i);
            if (s.addDigits(i) != s.addDigits2(i)) {
                System.out.println("wrong");
                break;
            }
        }
    }
}
