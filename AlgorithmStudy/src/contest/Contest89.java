package contest;

public class Contest89 {

    public int convertTime(String current, String correct) {
        // 00:00 ~ 23:59
        // 1, 5, 15, 60

        int currMin = (Integer.parseInt(current.substring(0, 2)) * 60) + Integer.parseInt(current.substring(3, 5));
        int corrMin = (Integer.parseInt(correct.substring(0, 2)) * 60) + Integer.parseInt(correct.substring(3, 5));

        int diff = corrMin - currMin;

        int oper = 0;

        oper += (diff / 60);
        diff = diff % 60;
        oper += diff / 15;
        diff = diff % 15;
        oper += diff / 5;
        diff = diff % 5;
        oper += diff;

        return oper;
    }


    public static void main(String[] args) {
        Contest89 c = new Contest89();
        // 59 -> 3, 14 -> 2, 4 -> 4

    }
}
