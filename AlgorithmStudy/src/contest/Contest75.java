package contest;

public class Contest75 {

    public long minimumTime(int[] time, int totalTrips) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < time.length; i++) {
            min = Math.min(time[i], min);
            max = Math.max(time[i], max);
        }
        long left = min;
        long right = (long)totalTrips * (long)max; // 여기서 좀 많이 틀림.

        while (left < right) {
            long mid = left + (right - left) / 2;

            long total = 0;
            for(int t : time){
                total += mid / t;
            }

            System.out.println("left : " + left + ", right : " + right + ", mid : " + mid + ", t : " + total);
            /*if ( t == totalTrips) {
                right = mid - 1;
            }*/
            if (total >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Contest75 c = new Contest75();

        System.out.println(c.minimumTime(new int[]{5, 10, 10}, 9)); // 25
        System.out.println(c.minimumTime(new int[]{9,3,10,5}, 2)); // 5

        /*System.out.println(c.minimumTime(new int[]{1,2,3}, 5));
        System.out.println(c.minimumTime(new int[]{2}, 1));
        System.out.println(c.minimumTime(new int[]{1,2,3}, 6));
        System.out.println(c.minimumTime(new int[]{1,2,3}, 7));
        System.out.println(c.minimumTime(new int[]{1,2,3}, 8));
        System.out.println(c.minimumTime(new int[]{1,2,3}, 9));
        System.out.println(c.minimumTime(new int[]{1,2,3}, 10));
        System.out.println(c.minimumTime(new int[]{1,2,3}, 11));*/

    }
}
