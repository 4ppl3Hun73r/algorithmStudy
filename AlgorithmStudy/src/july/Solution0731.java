package july;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3832/
public class Solution0731 {

    /**
     * 입력은 O(1)
     * 출력은 O(N * P)
     *
     * 출력을 O(1) 로 바꾸려먼
     * 입력 시점에 미리 계산할수 있을듯
     *
     */
    class MapSum {
        Map<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<String, Integer>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int result = 0;

            for (String key: map.keySet()) {
                if (key.startsWith(prefix)) {
                    result += map.get(key);
                }
            }

            return result;
        }
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}
