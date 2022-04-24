package contest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Contest98 {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public int countLatticePoints(int[][] circles) {

        /*
        circles = [x, y, r]
         */
        Set<Point> set = new HashSet<>();

        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            int sX = x - r;
            int eX = x + r;
            int sY = y - r;
            int eY = y + r;

            double radis = Math.pow(r, 2);
            for (int i = sX; i <= eX ; i++) {
                for (int j = sY; j <= eY ; j++) {
                    Point p = new Point(i, j);
                    if (!set.contains(p)) {
                        if (radis >= (Math.pow(x - i, 2) + Math.pow(y - j, 2))) {
                            set.add(p);
                        }
                    }
                }
            }
            System.out.println(set.size());

        }

        //if (Math.pow(R, 2) >= (Math.pow(X - TX, 2) + Math.pow(Y - TY, 2))) {


        return set.size();
    }


    public static void main(String[] args) {
        Contest98 c = new Contest98();

        /*
        1 <= circles.length <= 200
        circles[i].length == 3
        1 <= xi, yi <= 100
        1 <= ri <= min(xi, yi)
         */

        //System.out.println(c.countLatticePoints(new int[][]{{2,2,2},{3,4,1}}));

        int x = 100;
        int y = 100;
        int r = 100;
        for (int i = 0; i < 100; i++) {
            System.out.printf("[%d,%d,%d],", x, y, r);
            x--;
            r--;
            y--;
        }



    }
}
