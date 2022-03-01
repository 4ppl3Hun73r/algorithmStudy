package problems;

// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int productDigit = 1;
        int sumDigit = 0;

        while (n != 0) {
            int t = n % 10;
            n = n / 10;
            productDigit *= t;
            sumDigit += t;
        }

        return productDigit - sumDigit;
    }
}
