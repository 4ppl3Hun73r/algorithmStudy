package problems;

import java.util.PriorityQueue;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((a, b) -> {
            String ab = a + b;
            String ba = b + a;

            return ba.compareTo(ab);
        });

        for (int num : nums) {
            priorityQueue.add(String.valueOf(num));
        }

        if (priorityQueue.peek().equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }

        return sb.toString();
    }
}
