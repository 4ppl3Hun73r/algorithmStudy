package y2022.aug;


// https://leetcode.com/problems/poor-pigs/
public class Solution0806 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        /*


        buckets = 4, minutesToDie 15, minutesToTest 15 일때 한번에 찾는 방법
         buckets [ 0][ 1][ 2][ 3]
         eat          A   B  AB


                    A   A  A  AB  B   B   B

        2 마리 일떄 4개를 한번에 검사 가능(?)

        검사 횟수를 구해보자 -> minutesToTest / minutesToDie


        2마리가 1회에 검사 할 수 있는 최대 수는?
              2회에?
              3회에?


        N마리가 1회에?
              2회에?
              3회에?

         */


        int round = minutesToTest / minutesToDie;

        return (int)Math.ceil(Math.log(buckets)/Math.log(round+1));
    }
}
