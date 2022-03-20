package y2022.mar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0319 {
}

class FreqStack {

    Map<Integer, List<Integer>> countValMap;
    Map<Integer, Integer> valCountMap;
    int freq = 0;

    public FreqStack() {
        countValMap = new HashMap<>();
        valCountMap = new HashMap<>();
    }

    public void push(int val) {
        int index = valCountMap.getOrDefault(val, 0) + 1;
        valCountMap.put(val, index);
        if (!countValMap.containsKey(index)) {
            countValMap.put(index, new ArrayList<>());
        }
        countValMap.get(index).add(val);

        freq = Math.max(freq, index);
    }

    public int pop() {
        List<Integer> list = countValMap.get(freq);
        int ret = list.remove(list.size() - 1);

        if (list.size() == 0) {
            freq--;
        }
        valCountMap.put(ret, valCountMap.get(ret) - 1);

        return ret;
    }
}
