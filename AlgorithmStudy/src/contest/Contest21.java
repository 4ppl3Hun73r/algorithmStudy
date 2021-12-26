package contest;

public class Contest21 {
    public boolean isSameAfterReversals(int num) {

        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int reverse = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(String.valueOf(reverse));
        int reverse2 = Integer.parseInt(sb.reverse().toString());

        return num == reverse2;

    }

    public static void main(String[] args) {
        Contest21 c = new Contest21();
    }
}
