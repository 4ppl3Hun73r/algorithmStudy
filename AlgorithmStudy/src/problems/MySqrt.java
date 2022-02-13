package problems;

public class MySqrt {
    public int mySqrt(int x) {
        /*
        sqrt(x) => root(x)
        4 => 2
        8 => 2.82842... => 2
        9 => 3


        2^31 -1 => 46340


        y = sqrt(x)
        y * y = x
         */
        int result = (int)Math.sqrt(x);
        System.out.println(Integer.toBinaryString(x) + " : " + Integer.toBinaryString(result));

        return result;
    }

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        for (int i = 1; i > 0 && i < Integer.MAX_VALUE; i = i * 2) {
            System.out.println(i + " : " + m.mySqrt(i));
        }
        System.out.println(Integer.MAX_VALUE + " : " + m.mySqrt(Integer.MAX_VALUE));
    }
}
