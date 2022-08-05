package y2022.aug;

// https://leetcode.com/problems/mirror-reflection/
public class Solution0804 {
    public int mirrorReflection(int p, int q) {
        /*
        정사각형의 길이 p

        좌하단에서 빛을 오른쪽 면 q의 위치(아래에서 계산) 으로 발사 했을때
        좌상단(2), 우상단(1), 우하단(0)에 처음으로 빛이 도달하는 번호 반환

        빛이 도착지점에 도달하는건 보장됨.

        |---------|---------|---------|---------|---------|---------|---------|---------|
        S         0         1         2         3         S         0         1         2
        p          < q >
                       |
                     q                     | q
                          q    q  |

                  ^         ^         ^         ^

         distance -> p, 2p, 3p mod 0 -> (1, 2, 3) - 1 이 답이 된다


         |---------|---------|---------|---------|---------|---------|---------|---------|
         S         0         1         2         S         0         1         2         2
                        ^
                      q   p-q

          https://leetcode.com/problems/mirror-reflection/discuss/146336/Java-solution-with-an-easy-to-understand-explanation


          ------------
          |          |
       p  |          |
          |          |
          |          |
          ------------
          |          |
       p  |          |
          |          |  q
          |          |
          ------------
          |          |
       p  |          |
          |          |  q
          |          |
          ------------
           p = n, q = m
            mp = qn

            2p = 3q -> 우하단 0
            p = 2q -> 좌상단 2
            p = q -> 우상단  1

            4, 2 -> 0, 0
            2, 1 -> 0, 1
         */

        int m = q, n = p;
        // 둘중 하나가 홀수가 나올때까지 나누기
        // 왜냐면, 0,0 은 답이아닌데 이 케이스를 제외하기 위해서.
        while(m % 2 == 0 && n % 2 == 0){
            m /= 2;
            n /= 2;
        }

        if (m % 2 == 0 && n % 2 == 1) return 0;
        if (m % 2 == 1 && n % 2 == 1) return 1;
        if (m % 2 == 1 && n % 2 == 0) return 2;
        return -1;

    }


    public int mirrorReflection2(int p, int q) {
        // the first ray segment goes from 0,0, to p,q
        // next, the ray will intersect with either left or top wall
        // with a slope of -p/q
        // if it ever hits the top wall
        // the slop becomes pq
        // bottom wall?
        // -pq
        Point current = new Point(0, 0, 1.0*p/q);
        while(corner(current, p) == -1) {
            //  System.out.println(current.x + "," + current.y);
            current = getNext(current, p);
        }
        //System.out.println(current.x + "," + current.y);

        return corner(current, p);
    }
    boolean eq(double a, double b) {
        return Math.abs(b-a) < 0.00000001;
    }
    int corner(Point pt, double p) {
        if(eq(pt.x,p) && eq(pt.y,0)) {
            return 0;
        }
        if(eq(pt.x, p) && eq(pt.y ,p)) {
            return 1;
        }
        if(eq(pt.x, 0) && eq(pt.y, p)) {
            return 2;
        }
        return -1;
    }
    Point getNext(Point current, double p) {
        double nextSlope = -current.slope;
        double slope = current.slope;
        if(current.x != 0) {
            // not touching left wall
            // solve for left wall
            double y = (slope*current.y - current.x) / current.slope;
            if(y >= 0 && y <= p) {
                return new Point(0, y, nextSlope);
            }
        }

        if(current.x != p) {
            // not touching the right wall
            // agian (x - x1) = slope*(y-y1)
            // where in this case, x = p
            double y = (slope*current.y - current.x + p) / current.slope;
            if(y >= 0 && y <= p) {
                return new Point(p, y, nextSlope);
            }
        }
        if(current.y != 0) {
            // not touching the bottom
            // (x-x1) = slope*(y-y1)
            // in this case, y = 0
            // we want x
            double x = slope*(-current.y) + current.x;
            if(x >= 0 && x <= p) {
                return new Point(x, 0, nextSlope);
            }
        }
        if(current.y != p) {
            // not touching the top
            // (x-x1) = slope*(y-y1)
            // in this case, y = p
            // we want x
            double x = slope*(p-current.y) + current.x;
            if(x >= 0 && x <= p) {
                return new Point(x, p, nextSlope);
            }
        }
        return null;
    }


    class Point{
        double x;
        double y;
        double slope;
        Point(double x, double y, double slope) {
            this.x = x;
            this.y= y;
            this.slope = slope;
        }
    }
}
