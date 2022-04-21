package y2022.apr;

// https://leetcode.com/problems/design-hashset/
public class Solution0421 {
    /*
    1000000 개 까지 들어 올 수 있음

    https://leetcode.com/problems/design-skiplist/

     * ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
 * [[],[1],[2],[1],[3],[2],[2],[2],[2]]
     */

    public static void main(String[] args) throws Exception {
        MyHashSet set = new MyHashSet();

        set.add(1);
        set.add(2);
        set.contains(3);
        set.contains(2);
        set.add(2);
        set.contains(2);
        set.remove(2);
        set.contains(2);

        System.out.println();
    }

}

// 안녕하세요?
// 들리시죠?
class MyHashSet {
    class HashObject {
        HashObject next;
        int val;
        public HashObject(int val) {
            this.val = val;
        }
    }

    private final int size = 10000; // 100
    HashObject[] buckets = new HashObject[size];

    public MyHashSet() {
        // HashMap hashMap = new HashMap();
    }

    public void add(int key) {
        int hashKey = hash(key);
        HashObject bucket = buckets[hashKey];

        if (bucket == null) {
            buckets[hashKey] = new HashObject(key);
        } else {
            // 충돌시 처리
            HashObject temp = bucket;
            HashObject prev = temp;
            while (temp != null) {
                if (temp.val == key)
                    return ;
                prev = temp;
                temp = temp.next;
            }
            prev.next = new HashObject(key);
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        HashObject bucket = buckets[hashKey];

        if (bucket != null) {
            HashObject temp = bucket;
            HashObject prev = temp;
            while (temp != null) {
                if (temp.val == key)
                    break ;
                prev = temp;
                temp = temp.next;
            }
            if (temp != null) {
                if (temp == bucket) {
                    buckets[hashKey] = temp.next;
                } else {
                    prev.next = temp.next;
                    temp.next = null;
                }
            }
        }
    }

    public boolean contains(int key) {
        int hashKey = hash(key);
        HashObject bucket = buckets[hashKey];

        if (bucket != null) {
            HashObject temp = bucket;
            while (temp != null) {
                if (temp.val == key)
                    return true ;
                temp = temp.next;
            }
        }

        return false;
    }
}
/***
 * ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
 * [[],[1],[2],[1],[3],[2],[2],[2],[2]]
 *
 *
 * output -> [null,null,null,true,false,null,true,null,true]
 * expected -> [null,null,null,true,false,null,true,null,false]
 */