package y2023.may

// https://leetcode.com/problems/design-underground-system
class Solution0521 {
}

class UndergroundSystem() {

    data class Pair(val stationName: String, val time: Int) {}

    private val idPairMap: MutableMap<Int, Pair> = mutableMapOf()
    private val stationsTimeMap: MutableMap<String, MutableList<Int>> = mutableMapOf()

    fun checkIn(id: Int, stationName: String, t: Int) {
        idPairMap[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val pair = idPairMap.remove(id)
        if (pair != null) {
            val stations = pair.stationName + "-" + stationName
            if (!stationsTimeMap.containsKey(stations)) {
                stationsTimeMap[stations] = mutableListOf()
            }
            stationsTimeMap[stations]?.add(t - pair.time)
        }

    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val stations = "$startStation-$endStation"

        val lists: List<Int>? = stationsTimeMap[stations]
        var total: Double = 0.0
        lists?.forEach { total += it }

        return total / lists?.size!!
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */
