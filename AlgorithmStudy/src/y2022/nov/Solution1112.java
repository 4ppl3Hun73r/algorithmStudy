package y2022.nov;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
public class Solution1112 {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();

        m.addNum(-1);
        //System.out.println(m.findMedian());
        m.addNum(-2);
        //System.out.println(m.findMedian());
        m.addNum(-3);
       // System.out.println(m.findMedian());
        m.addNum(-4);
        //System.out.println(m.findMedian());
        m.addNum(-5);
        //System.out.println(m.findMedian());


        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
    }
}




class MedianFinder {
    private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        left.offer(-1000000);
        right.offer(1000000);
    }

    public void addNum(int num) {
        Integer l = left.peek();
        Integer r = right.peek();

        if (num <= l) {
            left.offer(num);
        } else if (r < num) {
            right.offer(num);
        } else {
            left.offer(num);
        }

        while (true) {
            int leftSize = left.size();
            int rightSize = right.size();

            if (Math.abs(leftSize - rightSize) < 2) {
                break;
            }

            if (leftSize > rightSize) {
                right.offer(left.poll());
            } else {
                left.offer(right.poll());
            }
        }

        print(left);
        print(right);
    }

    public double findMedian() {
        int leftSize = left.size();
        int rightSize = right.size();

        print(left);
        print(right);

        if (leftSize < rightSize) {
            return right.peek();
        } else if (leftSize > rightSize) {
            return left.peek();
        }

        return (double)(left.peek() + right.peek()) / 2;
    }

    void print(PriorityQueue<Integer> pq) {
        int size = pq.size();

        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(pq.poll());
        }
        System.out.println(list);
        pq.addAll(list);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */