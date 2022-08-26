package y2022.aug;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/reduce-array-size-to-the-half/
public class Solution0818 {
    public int minSetSize(int[] arr) {
        /*
        배열의 반절이하로 만들 수 있는 가장 작은 set의 길이
        배열을 적어도 절반이 제거되도록 하는 가장 작은 set의 길이

        [3,3,3,3,5,5,5,2,2,7]
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> b - a);

        int size = arr.length;
        int half = size / 2;
        int cnt = 0;
        int ans = 0;
        for (ans = 0; ans < list.size(); ans++) {
            if (cnt >= half) {
                break;
            }
            cnt += list.get(ans);
        }

        return ans;
    }

    public int minSetSizeStream(int[] arr) {
        List<Long> sortedCount = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        long sum = 0;
        int count = 0;
        for(long el: sortedCount){
            count++;
            sum +=el;
            if(sum >= arr.length/2){
                break;
            }
        }
        return count;
    }

    public int minSetSize2(int[] arr) {
        int min = 1000000, max = 0;
        for (int val : arr) {
            min = Math.min(val,min);
            max = Math.max(val,max);
        }
        int[] count = new int[max-min+1];
        for (int val : arr) {
            count[val-min]++;
        }
        int[] bucket = new int[arr.length+1];
        for (int val : count) {
            if (val != 0) bucket[val]++;
        }

        int size = 0, sum = 0;
        final int half = arr.length>>1;
        for (int i = arr.length; i > 0; i--) {
            while (bucket[i]-- != 0) {
                sum += i;
                size++;
                if (sum >= half) return size;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Solution0818 s = new Solution0818();

        for (int j = 0; j < 10; j++) {
            int[] nums = new int[100000];
            Random r = new Random();
            for (int i = 0; i < nums.length; i++) {
                nums[i] = r.nextInt();
            }

            long time = System.currentTimeMillis();
            s.minSetSize(nums);
            long diffTime = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            s.minSetSizeStream(nums);
            long diffTime2 = System.currentTimeMillis() - time;

            System.out.println("S : " + diffTime + ", T : " + diffTime2);
        }

    }
}
