package problems;

public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        /*
        y = ax + b

        a0 = y0 - y1 / x0 - x1;
        b = (x1y0 - x0y1) / x1 - x0;

        a1 = y0 - y2 / x0 - x2;

        a0 == a1 이므로
        (y0 - y1) / (x0 - x1) = (y0 - y2) / (x0 - x2)
        곱으로 바꾸면 (y0 - y1) * (x0 - x2) == (y0 - y2) * (x0 - x1)
         */

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];

            if ((y0 - y1) * (x0 - x2) != (y0 - y2) * (x0 - x1)) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) throws Exception {
        CheckIfItIsAStraightLine s = new CheckIfItIsAStraightLine();
        System.out.println(s.checkStraightLine(new int[][]{
                {0,0},{0,1},{0,-1}
        }));
    }

}
