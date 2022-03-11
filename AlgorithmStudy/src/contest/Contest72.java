package contest;

import java.util.*;

public class Contest72 {

    public long coutPairs(int[] nums, int k) {
        long res = 0;

        Map<Integer, Integer> modCntMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                res += i;
                modCntMap.put(0, modCntMap.getOrDefault(0, 0) + 1);
            } else {
                // k로 나눠 떨어지지 않으면 최대 공약수를 구해 놓는다.
                int gcd = gcd(nums[i], k);
                int find = k / gcd;
            }

        }


        return res;
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        } else{
            return gcd(b, a%b);
        }
    }

    /**
     * 모든 공약수를 볼 필요는 없다.
     * k와의 최대 공약수만을 확인 하면 됨
     */
    public long coutPairsFail(int[] nums, int k) {
        long res = 0;

        // 공약수 -> 가 포함되어 있냐?
        /*
         1을 제외한 공약수 연결되어서 처리가 되어야 함.
         */
        // System.out.println(getDivisors(k));
        List<Integer> kDivisor = getDivisors(k);
        Map<Integer, Set<Integer>> divisorIndexMap = new HashMap<>();
        List<Integer>[] divisorArr = new ArrayList[nums.length];
        for (Integer divisor : kDivisor) {
            divisorIndexMap.put(divisor, new TreeSet<>());
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> nDivisor = getDivisors(nums[i]);
            List<Integer> fillterDivisor = new ArrayList<>();
            for (Integer divisor : nDivisor) {
                if (divisorIndexMap.containsKey(divisor)) {
                    divisorIndexMap.get(divisor).add(i);
                    fillterDivisor.add(divisor);
                }
            }
            divisorArr[i] = fillterDivisor;
        }

        for (int i = 0; i < divisorArr.length; i++) {
            List<Integer> divisor = divisorArr[i];

            Set<Integer> uniqueIndexSet = new HashSet<>();
            for (int j = 0; j < divisor.size(); j++) {
                int div = divisor.get(j);
                int find = k / div;
                Set<Integer> findDivisor = divisorIndexMap.get(find);
                findDivisor.remove(i); // 자기 자신이 있으면 제거
                divisorIndexMap.get(div).remove(i); // 양쪽에서 자기 자신을 제거
                uniqueIndexSet.addAll(findDivisor);
            }
            res += uniqueIndexSet.size();
            //System.out.println(i);
            //System.out.println(uniqueIndexSet);
        }

        return res;
    }

    private List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        divisors.add(n);
        return divisors;
    }

    public static void main(String[] args) {
        Contest72 c = new Contest72();

        //System.out.println(c.coutPairs(new int[]{1,2,3,4}, 5));
        // System.out.println(c.coutPairs(new int[]{8,10,2,5,9,6,3,8,2}, 6)); //18

        /*System.out.println(c.coutPairs(new int[]{1,2,3,4,5}, 10));
        System.out.println(c.coutPairs(new int[]{1,2,3,4,5}, 2));
        System.out.println(c.coutPairs(new int[]{1,2,3,4,5}, 10000));*/
        
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            System.out.print(r.nextInt(100000) + 1);
            System.out.print(",");
        }

    }
}
