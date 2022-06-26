package problems;

// https://leetcode.com/problems/calculate-amount-paid-in-taxes/
public class CalculateAmountPaidInTaxes {

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0f;

        int before = 0;
        for (int i = 0; i < brackets.length; i++) {
            int[] bracket = brackets[i];

            if (income < bracket[0]) {
                tax += (((income - before) * bracket[1]) / 100f);
                break;
            }

            tax += (((bracket[0] - before) * bracket[1]) / 100f);
            before = bracket[0];
        }

        return tax;
    }

    public static void main(String[] args) {
        CalculateAmountPaidInTaxes c = new CalculateAmountPaidInTaxes();

        System.out.println(c.calculateTax(new int[][]{
                {3, 50},{7,10},{12,25}
        }, 10)); // 2.650
    }
}
