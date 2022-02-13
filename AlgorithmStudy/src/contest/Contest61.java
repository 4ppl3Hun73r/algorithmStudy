package contest;

public class Contest61 {
    public int countOperations(int num1, int num2) {

        int cnt = 0;
        while (!(num1 == 0 || num2 == 0)) {
            cnt++;
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }

        return cnt;
    }



    public static void main(String[] args) {
        Contest61 c = new Contest61();

    }
}
