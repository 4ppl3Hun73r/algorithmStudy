package problems;

public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;

        char[] arr = s.toCharArray();
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if ('I' == c) {
                if (i != arr.length - 1 && arr[i + 1] == 'V') {
                    sum += 4;
                    i++;
                } else if (i != arr.length - 1 && arr[i + 1] == 'X') {
                    sum += 9;
                    i++;
                } else {
                    sum += 1;
                }
            } else if ('V' == c) {
                sum += 5;
            } else if ('X' == c) {
                if (i != arr.length - 1 && arr[i + 1] == 'L') {
                    sum += 40;
                    i++;
                } else if (i != arr.length - 1 && arr[i + 1] == 'C') {
                    sum += 90;
                    i++;
                } else {
                    sum += 10;
                }
            } else if ('L' == c) {
                sum += 50;
            } else if ('C' == c) {
                if (i != arr.length - 1 && arr[i + 1] == 'D') {
                    sum += 400;
                    i++;
                } else if (i != arr.length - 1 && arr[i + 1] == 'M') {
                    sum += 900;
                    i++;
                } else {
                    sum += 100;
                }
            } else if ('D' == c) {
                sum += 500;
            } else if ('M' == c) {
                sum += 1000;
            }
        }


        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();

        System.out.println(r.romanToInt("MCMXCIV"));
    }
}
