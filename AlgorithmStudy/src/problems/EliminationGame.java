package problems;

public class EliminationGame {

    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }

        return 2 * (1 + n / 2 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {
        EliminationGame e = new EliminationGame();

        System.out.println(e.lastRemaining(9));
    }
}
