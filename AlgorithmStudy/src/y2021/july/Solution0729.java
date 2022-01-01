package y2021.july;

// https://leetcode.com/explore/featured/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3829/
// 30분내에 해결하지 못해서 10분간 답을 보았지만 이해 못해서 각자 확인하는 걸로...
public class Solution0729 {
    public int[] beautifulArray(int n) {

        // 아름다운 배열
        // 2*a[k] != a[i] + a[j] / i < k < j
        // a[i] != a[j] - 2*a[k]
        // a[k] != a[i] - 2*a[k]

        // [1]
        // [2,1]
        // [2,1,3]
        // [2,1,4,5,3]
        // [2,1,4,5,3]
        // [3,1,2,5,4]
        // [1,5,3,2,6,4]
        // [3,1,2,5,6,4] -- n = 6
        // [1,5,3,7,2,6,4] -- n = 7
        // [1,5,3,7,2,6,4,8] -- n = 8 <- 1+8 = 9 / 5+4 = 9 /

        // 짝수 : 집합
        // 홀수 : 집합

        // 짝수 [2,4,6,   5,7,9] 호

        // 6
        // [1, 3, 5]
        // [2, 4, 6]
        // [5,3 1 2 4,6]

        // (1, 2, ..., n), it is satisfied by those variables taking on values
        // (a + b, a + 2*b, a + 3*b, ..., a + (n-1)*b) instead.
/*
        for (int x: f(N+1/2))  // odds
            ans[t++] = 2*x - 1;
        for (int x: f(N/2))  // evens
            ans[t++] = 2*x;*/
        // 6
        // [1, 3, 5]
        // [2, 4, 6]
        // ans = [ , , , , , ,]
        //

        // 1: [1]
        // 2: [1, 2]
        // 3: [1, 3, 2]



        int[] result = new int[n];
        result[0] = 1;
        int index = 1;
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < index; j++) {

            } // 짝수
            for(int j = 0; j < index; j++) {

            } // 홀수

            index++;
        }


        return result;
    }


    // [ 1, 2, 3, 4, 5, 6 ]

    // nums[i] = nums[k] * 2 - nums[j]

    // i = 0 => 1 = 4 - 3 X
    // i = 1 => 2 = 3*2 - 4 X
    // i = 2 => 3 = 4*2 - 5 O , 3 = 4*2 - 6 O
    // i = 3 => 4 = 5*2 - 6 O
    // i = 4 => 5 =
}


// [1]
// [1,2]
// [3,1,2]
// [3,4,1,2]
// [3,5,4,1,2]
// [3,5,4,6,1,2]
// [3,5,4,6,1,2]

// [1]
// [1,2]
// [3,1,2]
// [3,4,1,2]
// [3,5,4,1,2]
// [3,5,4,6,1,2]