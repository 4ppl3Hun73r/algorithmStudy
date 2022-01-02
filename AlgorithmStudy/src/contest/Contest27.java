package contest;

import java.util.Arrays;

public class Contest27 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        long massL = mass;
        for (int asteroid : asteroids) {
            if (massL < asteroid) {
                return false;
            }
            massL += asteroid;
        }

        return true;
    }

    public static void main(String[] args) {
        Contest27 c = new Contest27();

    }
}
