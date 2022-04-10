package contest;

import java.util.PriorityQueue;

public class Contest95 {
    /*
    결과를 구하는걸 생각을 잘 못해서 시도도 못해보고 제출 못했네.. 거참..
     */
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.add(num);
        }

        while ( k-- > 0) {
            priorityQueue.add(priorityQueue.poll() + 1);
        }

        long output = 1;
        while(!priorityQueue.isEmpty()) {
            output = (priorityQueue.poll() % mod) * (output % mod) ;
        }

        return (int) (output % mod);
    }


    public static void main(String[] args) {
        Contest95 c = new Contest95();

    }
}
