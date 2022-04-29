package y2022.apr;

// https://leetcode.com/problems/design-hashmap/
public class Solution0422 {
}

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size = 10000;
    Node[] buckets = new Node[size];
    public MyHashMap() {
    }

    private int hash(int key) {
        return key % size;
    }

    private Node getBucket(int key) {
        int hashKey = hash(key);

        return buckets[hashKey];
    }

    public void put(int key, int value) {
        Node node = getBucket(key); // null;

        if (node == null) {
            int hashKey = hash(key);
            buckets[hashKey] = new Node(key, value);
        } else {
            // 충돌이 일어나서 탐색해야됨
            Node temp = node;
            Node prev = temp;

            while (temp != null) {
                // key가 중복이면 value를 업데이트 해주고
                if (temp.key == key) {
                    temp.val = value;
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                // key가 없으면 신규 노드 생성
                prev.next = new Node(key, value);
            }
        }
    }

    public int get(int key) {
        Node node = getBucket(key);
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }

        return -1;
    }

    public void remove(int key) {
        Node node = getBucket(key);
        if (node != null && node.key == key) { // bucket 시작에 값이 있다.
            buckets[hash(key)] = node.next;
            return ;
        }

        Node temp = node;
        Node prev = node;
        while (temp != null) {
            if (temp.key == key) {
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            prev.next = temp.next;
            //temp.next = null;
        }
    }
    //안녕하세요

}