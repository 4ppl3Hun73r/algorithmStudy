package problems;

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        long sum = 0;
        for (int s : salary) {
            sum += s;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }

        sum = sum - min - max;


        return (double) sum / (double) (salary.length - 2);


    }
}
