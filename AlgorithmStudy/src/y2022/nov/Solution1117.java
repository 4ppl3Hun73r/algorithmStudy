package y2022.nov;

// https://leetcode.com/problems/rectangle-area/
public class Solution1117 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        /*

              ax1 ------------------- ax2
                         bx1 ----------------------bx2  (bx1 ~ ax2) bx1 < ax2
        bx1 --------------------------------- bx2   (ax1 ~ ax2) ax1 < ax2
                                             bx1 ----------------------bx2  (bx1, ax2) -> bx1 > ax2
bx1 ----bx2   (ax1, bx2) ax1 > bx2

        pass : Max(ax1,bx1) > min(ax2,bx2)

        max(ax1, bx1) -> min(ax2,bx2)
                ax1, ax2

        bx1            bx1                bx1
              cx1      cx1                cx1 = 0

        bx1 <= ax1 => cx1 = ax1;
        ax1 < bx1 < ax2 => cx1 = bx1


                ax1 ------------------- ax2
        bx1 bx2
        bx1              bx2
        bx1                                     bx2
        
        bx2 < ax1 => cx2 = 0;
        ax1 < bx2 < ax2 => cx2 = bx2
        ax2 < bx2 => cx2 = bx2

            bx1 > ax2

         */

        int cx1 = Math.max(ax1, bx1);
        int cx2 = Math.min(ax2, bx2);
        int cy1 = Math.max(ay1, by1);
        int cy2 = Math.min(ay2, by2);


        return area(ax1, ax2, ay1, ay2) + area(bx1, bx2, by1, by2) -
                area(cx1, cx2, cy1, cy2);
    }

    private int area(int x1, int x2, int y1, int y2) {
        if (x2 < x1) {
            return 0;
        }
        if (y2 < y1) {
            return 0;
        }
        System.out.println(String.format("%d %d %d %d", x1, x2, y1, y2));

        return Math.abs((x2 - x1)) * Math.abs((y2 - y1));
    }

    public static void main(String[] args) throws Exception {
        Solution1117 s = new Solution1117();

        System.out.println(s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
