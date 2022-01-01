package y2021.aug;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3917/
public class Solution0825 {

    public String complexNumberMultiply(String num1, String num2) {
        String[] parse = num1.split("\\+");
        int real1 = Integer.parseInt(parse[0], 10);
        int imaginary1 = Integer.parseInt(parse[1].substring(0, parse[1].length() - 1), 10);

        parse = num2.split("\\+");
        int real2 = Integer.parseInt(parse[0], 10);
        int imaginary2 = Integer.parseInt(parse[1].substring(0, parse[1].length() - 1), 10);

        int real = (real1 * real2) - (imaginary1 * imaginary2);
        int imaginary = (real1 * imaginary2) + (real2 * imaginary1);

        return String.format("%d+%di", real, imaginary);
    }

}

