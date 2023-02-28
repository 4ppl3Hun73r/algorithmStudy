package y2023.feb;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/ipo/
public class Solution0223 {

    class Job {
        int profit;
        int capital;
        public Job(int a, int b) {
            this.profit = a;
            this.capital = b;
        }
    }


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Comparator<Job> comparator = (a, b) -> {
            if (a.capital != b.capital) {
                return a.capital - b.capital;
            }
            return b.profit - a.profit;
        };

        Comparator<Job> comparatorProfit = (a, b) -> {
            if (a.profit != b.profit) {
                return b.profit - a.profit;
            }
            return a.capital - b.capital;
        };
        PriorityQueue<Job> pq = new PriorityQueue<>(comparator);
        PriorityQueue<Job> pqProfit = new PriorityQueue<>(comparatorProfit);

        for (int i = 0; i < profits.length; i++) {
            pq.offer(new Job(profits[i], capital[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!pq.isEmpty()) {
                Job job = pq.peek();
                if (job.capital > w) {
                    break;
                }
                pqProfit.offer(pq.poll());
            }


            Job job = pqProfit.poll();
            if (job == null ) {
                break;
            }
            w += job.profit;
        }


        return w;
    }

    public static void main(String[] args) throws Exception {
        Solution0223 s = new Solution0223();

        System.out.println(s.findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}));
    }

}
