package y2022.sep;

// https://leetcode.com/problems/design-circular-queue/
public class Solution0925 {
}



class MyCircularQueue {

    int[] queue;
    int frontIdx = 0;
    int rearIdx = -1;
    int cnt = 0;
    int k = 0;

    public MyCircularQueue(int k) {
        queue = new int[k];
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (cnt >= k) {
            return false;
        }
        rearIdx++;
        rearIdx = rearIdx % k;
        queue[rearIdx] = value;
        cnt++;

        return true;
    }

    public boolean deQueue() {
        if (cnt == 0) {
            return false;
        }
        frontIdx++;
        frontIdx = frontIdx % k;
        cnt--;

        return true;
    }

    public int Front() {
        if (cnt == 0) {
            return -1;
        }
        return queue[frontIdx];
    }

    public int Rear() {
        if (cnt == 0) {
            return -1;
        }
        return queue[rearIdx];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */