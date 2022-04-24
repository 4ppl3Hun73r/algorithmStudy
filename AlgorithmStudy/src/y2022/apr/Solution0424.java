package y2022.apr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/design-underground-system/
public class Solution0424 {
}

class UndergroundSystem {

    class Pair {
        String stationName;
        int time;

        public Pair(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    Map<Integer, Pair> idPairMap;
    Map<String, List<Integer>> stationsTimesMap;

    public UndergroundSystem() {
        idPairMap = new HashMap<>();
        stationsTimesMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idPairMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair pair = idPairMap.remove(id);
        String stations = pair.stationName + "-" + stationName;
        if (!stationsTimesMap.containsKey(stations)) {
            stationsTimesMap.put(stations, new ArrayList<>());
        }
        stationsTimesMap.get(stations).add(t - pair.time);
    }

    public double getAverageTime(String startStation, String endStation) {
        String stations = startStation + "-" + endStation;

        List<Integer> lists = stationsTimesMap.get(stations);
        double total = 0;
        for (Integer time : lists) {
            total += time;
        }

        return total / lists.size();
    }
}
