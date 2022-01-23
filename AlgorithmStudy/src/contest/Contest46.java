package contest;

public class Contest46 {
    public int[] rearrangeArray(int[] nums) {
        /*
        nums.length even

        다시 정렬
        1. 모든 연속 쌍에 부호가 반대
        2. 부호가 같으면 숫자로 표시된 순서가 유지됨
        3. 양의 정수로 시작됨

        3,1,-2,-5,2,-4
        3,-2,1,-5,2,-4

        two pointer?
        배열 두개 만들어서 다시 조립?

        배열 shift?
         */

        int len = nums.length;
        int[] plus = new int[len/2];
        int[] minus = new int[len/2];

        int p = 0;
        int m = 0;
        for (int num : nums) {
            if (num < 0) {
                minus[m++] = num;
            } else {
                plus[p++] = num;
            }
        }


        for (int i = 0, k = 0; i < len; i+=2, k++) {
            nums[i] = plus[k];
            nums[i + 1] = minus[k];
        }

        return nums;
    }

    public static void main(String[] args) {
        Contest46 c = new Contest46();

        for (int i = 0; i < 100000; i++) {
            System.out.printf("%d,", i%10 + 1);
        }
        for (int i = 0; i < 100000; i++) {
            System.out.printf("-%d,", i%10 + 1);
        }
    }
}
