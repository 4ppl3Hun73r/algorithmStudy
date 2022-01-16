package contest;

public class Contest38 {
    public int minMoves(int target, int maxDoubles) {
        int move = 0;

        // maxDoubles 먼저 처리
        while (target != 1) {
            if (maxDoubles == 0) {
                break;
            }
            if (target % 2 == 0) {
                target = target /2;
                maxDoubles--;
            } else {
                target = target - 1;
            }
            move ++;
        }

        move = target - 1;

        return move;
    }

    public static void main(String[] args) {
        Contest38 c = new Contest38();

        System.out.println(c.minMoves(19, 2));
    }
}
