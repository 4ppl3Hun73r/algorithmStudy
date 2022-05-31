package y2022.jan;

public class Solution0118 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 서로 간격을 두고 꽃을 심을 수 있는지 확인

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (n == 0) {
                break;
            }

            int left = i - 1;
            int right = i + 1;

            boolean leftCheck = true;
            if (left >= 0 && flowerbed[left] == 1) {
                leftCheck = false;
            }

            boolean rightCheck = true;
            if (right < flowerbed.length && flowerbed[right] == 1) {
                rightCheck = false;
            }

            if (leftCheck && rightCheck) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        Solution0118 s = new Solution0118();

        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}
