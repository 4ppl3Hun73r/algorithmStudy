package problems;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        for (char c : jewels.toCharArray()) {
            cnt += map.getOrDefault(c, 0);
        }

        return cnt;
    }
}
