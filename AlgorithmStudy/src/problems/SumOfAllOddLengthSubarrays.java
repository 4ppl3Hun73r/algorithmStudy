package problems;

public class SumOfAllOddLengthSubarrays {

    public int sumOddLengthSubarrays(int[] arr) {
        // len == 100
        int ans = 0;

        /*
        [a,b,c,d,e,f,g]
        sum(a ~ g)
        sum(a~c, b~d, c~e, .d~f, e~g)
        sum(a~e, b~f, b~g)
         */

        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = arr[0];
        for (int i = 1; i <= arr.length ; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        /*
        0 ~ 3, 1  ~ 3
        0 ~ 5
        0 ~ 7
         */
        for (int i = 1; i <= arr.length; i+=2) {
            for (int j = 0; j < arr.length && j + i <= arr.length; j++) {
                ans += (prefixSum[j + i] - prefixSum[j]);
            }
        }

        //System.out.println(Arrays.toString(prefixSum));
        return ans;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays s = new SumOfAllOddLengthSubarrays();

        System.out.println(s.sumOddLengthSubarrays(new int[]{1,4,2,5,3})); // 58
    }
}
