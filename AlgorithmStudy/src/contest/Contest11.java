package contest;

public class Contest11 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {

        int left = 0;
        int right = plants.length - 1;

        int refillCnt = 0;
        int a = capacityA;
        int b = capacityB;
        while (left < right) {
            a = a - plants[left];
            if (a < 0) {
                refillCnt++;
                a = capacityA - plants[left];
            }
            b = b - plants[right];
            if (b < 0) {
                refillCnt++;
                b = capacityB - plants[right];
            }
            left++;
            right--;
        }

        if (left == right) {
            if (a < b) {
                a = a - plants[left];
                if (a <= 0) {
                    refillCnt ++;
                }
            } else {
                b = b - plants[left];
                if (b <= 0) {
                    refillCnt ++;
                }
            }
        }

        return refillCnt;
    }

    public static void main(String[] args) {
        Contest11 c = new Contest11();

        System.out.println(c.minimumRefill(new int[]{1,2,4,4,5}, 6, 5));
    }
}
