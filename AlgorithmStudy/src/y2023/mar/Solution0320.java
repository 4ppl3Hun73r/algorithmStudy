package y2023.mar;

// https://leetcode.com/problems/can-place-flowers/
public class Solution0320 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {


        // 0 -> 내 오른쪽 왼쪽에 1이 없어야되
        ///
        // 1, 0,0,0
        // ^
        // 0,0,0,0,0,0

        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (n == 0) {
                break;
            }

            int left = Math.max(0, i - 1);
            int right = Math.min(i + 1, len - 1);

            if (flowerbed[left] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
