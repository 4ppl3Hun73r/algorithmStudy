package problems;

//https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        return (n&n-1) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(16));
        System.out.println(p.isPowerOfTwo(15));
    }
}
