package problems;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        /*
        가장 작은 없는 positive number 를 반환
        O(n) 에 constant space 로 풀어야함


        1, 2, 0 -> 3
        3, 4, -1, 1 -> 2
        7,8,9,11,12 -> 1

        min을 찾고 -> 그 다음으로 계속 찾아 가면 되는데

        배열의 길이 안에서만 답이 있을 수 있음


         */
        // 일단 공간을 사용해서 O(n) 으로 풀어 보자
        // 그런데 이것도 쉬운건 아님...
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 답은 배열의 길이 안에서만 존재 할 수 있음
            // 즉 배열의 길이를 벗어나는 것들은 n + 1 값으로 변경 해놓기
            int num = nums[i];
            if (num <= 0 || num > len) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            int idx = Math.abs(nums[i]); // idx 를 가져오기
            if (idx > len) { // 배열을 벗어나는 값일 경우 continue;
                continue;
            }

            idx--; // 0 base로 맞추기
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx]; // 음수로 바꿔서 이 값은 있는 거라고 마킹
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                return i + 1; // i + 1 번째 값이 없었기 때문에 nums[i] 가 양수임.
            }
        }

        return len + 1; // 배열의 모든 값이 1~len까지 존재, 따라서 답은 len + 1 이 됨.
    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        // System.out.println(f.firstMissingPositive(new int[]{3,4,-1,1})); // 2
        System.out.println(f.firstMissingPositive(new int[]{7,8,9,11,12})); // 1

    }
}
