package sep;

//https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3965/
public class Solution0907 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int startTime = 0;
        int maxTime = Integer.MIN_VALUE;
        char slowestKey = keysPressed.charAt(0);

        char[] arr = keysPressed.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            char key = arr[i];
            int time = releaseTimes[i] - startTime;
            //System.out.println(String.format("%d %d", time, maxTime));

            if (time == maxTime) {
                slowestKey = slowestKey - key > 0 ? slowestKey : key;
            } else if (time > maxTime) {
                slowestKey = key;
                maxTime = time;
            }
            startTime = releaseTimes[i];
        }

        return slowestKey;
    }

    public static void main(String[] args) {
        Solution0907 s = new Solution0907();
        System.out.println(s.slowestKey(new int[]{12,23,36,46,62}, "spuda"));// a

        Boolean b = null;
        System.out.println( b || false);
    }
}
