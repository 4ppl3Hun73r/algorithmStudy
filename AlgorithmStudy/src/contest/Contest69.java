package contest;

public class Contest69 {
    public int countEven(int num) {
        int count = 0;

        int countTen = 2;
        for(int i = 2; i <= num; i++, countTen++) {
            int n = i;
            int sum = 0;
            while (n >= 10) {
                sum += (n % 10);
                n = n / 10;
            }
            sum += n;

            if (sum % 2 == 0) {
                //System.out.println(i);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Contest69 c = new Contest69();

        System.out.println(c.countEven(910));
        System.out.println(c.countEven(30));

        // 910 -> 455
    }
}
