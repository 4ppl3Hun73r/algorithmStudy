package aug;

import java.util.*;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/
public class Solution0812 {
    public boolean canReorderDoubled(int[] arr) {
        // [4,-2,2,-4] => true
        // [2,1,2,6] => false
        // 절대값 기준으로 정렬 -> 순회를 하면서 스왑
        // -2 2 4 -4 -> -2 -4 4 2
        // -2 2 4 -4

        // map ->
        //  -2 : 1 => remove
        //   2 : 1
        //   4 : 1
        //  -4 : 1 => remove
        //  0 ->
        // -4 -2 2 4
        // -2 2 4 -4

        Map<Integer, Integer> valueCntMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int cnt = valueCntMap.getOrDefault(val, 0);
            valueCntMap.put(val, cnt + 1);
        }

        // arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.
        Integer[] sorted = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparingInt(Math::abs))
                .toArray(Integer[]::new);

        // O(N) -> O(N/2) => O(NlogN)
        // System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int dValue = value * 2;

            // -33
            // value -> dValue 둘다 있어야 하자나요(map에).
            // dValue없으면 false
            if (valueCntMap.get(value) == 0) continue;
            if (valueCntMap.getOrDefault(dValue, 0) <= 0) return false;

            valueCntMap.put(value, valueCntMap.get(value) - 1);
            valueCntMap.put(dValue, valueCntMap.get(dValue) - 1);
        }

        return true;
    }

    public boolean canReorderDoubled2(int[] arr) {
        if(arr==null || arr.length==0)return true;
        int max=Integer.MIN_VALUE;
        for(int i:arr)max=Math.max(max,Math.abs(i));

        // -10^5 < arr[i] < 10^5

        int[] pos=new int[max+1]; // 10^5 + 1
        int[] neg=new int[max+1];
        for(int i:arr){
            if(i>=0){
                pos[i]++;
            }else{
                neg[Math.abs(i)]++;
            }
        }

        // 0 ~ 10^5 // O(N) -> 공간낭비가 너무 심하네요.
        for(int i=0;i<=max;i++){
            if(pos[i]>0){
                if(2*i>=pos.length || pos[2*i]<pos[i])return false;

                pos[2*i]-=pos[i]; // 중복수를 한번에 제거하네요. bb
            }

            if(neg[i]>0){
                if(2*i>=pos.length || neg[2*i]<neg[i])return false;

                neg[2*i]-=neg[i];
            }
        }

        return true;
    }

    public boolean canReorderDoubled3(int[] arr) {
        if(arr == null || arr.length == 0) return true;

        Map<Integer, Integer> pos = new TreeMap<>();
        Map<Integer, Integer> neg = new TreeMap<>();
        int zeroCnt = 0;

        for(int num : arr){
            if(num > 0){
                pos.put(num, pos.getOrDefault(num, 0) + 1);
            }else if(num < 0){
                neg.put(num, neg.getOrDefault(num, 0) + 1);
            } else {
                zeroCnt ++;
            }
        }

        // pos
        while(!pos.isEmpty()){
            int first = getFirst(pos);
            if(!pos.containsKey(first * 2)) return false;

            decrease(pos, first * 2);
            decrease(pos, first);
        }

        //neg
        while(!neg.isEmpty()){
            int first = getFirst(neg);
            if(first % 2 != 0 || !neg.containsKey(first / 2)) return false;

            decrease(neg, first / 2);
            decrease(neg, first);

        }

        return zeroCnt % 2 == 0;
    }

    public void decrease(Map<Integer, Integer> map, int num){
        int cnt = map.get(num);
        cnt --;
        if(cnt == 0){
            map.remove(num);
        } else {
            map.put(num, cnt);
        }
    }

    public int getFirst(Map<Integer, Integer> map){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution0812 s = new Solution0812();

        System.out.println(s.canReorderDoubled(new int[]{4,-2,2,-4}));
        System.out.println(s.canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(s.canReorderDoubled(new int[]{-33,0}));
        System.out.println(s.canReorderDoubled(new int[]{1,2,4,16,8,4}));
        //[4,-2,2,-4]
    }
}
