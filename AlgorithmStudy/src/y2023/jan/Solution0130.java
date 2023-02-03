package y2023.jan;

// https://leetcode.com/problems/n-th-tribonacci-number/
public class Solution0130 {

    int[] cache = new int[38];
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        return cache[n] = tribonacci(n-1) + tribonacci(n-2)+ tribonacci(n-3);
    }

    public int tribonacci2(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i=3; i<=n; i++){
            int temp = a+b+c;
            a=b;
            b=c;
            c=temp;
        }
        if(n==0) return 0;
        else if(n==1 || n==2){
            return 1;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        Solution0130 s = new Solution0130();

        System.out.println(s.tribonacci(37));
    }
}
