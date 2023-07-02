package y2023.jul

// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
class Solution0702 {

    var answer = 0
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        /*
       n개의 빌딩

       이동하고 싶어하는 직원들
       requests = [from, to]

       빌딩의 인원은 변동이 없어야 이동이 가능하다.

       최대로 처리 가능한 수?
        */
        val buildings = IntArray(n)
        backtracking(requests, buildings, n, 0, 0)
        return answer
    }

    fun backtracking(requests: Array<IntArray>, buildings: IntArray, n: Int, index: Int, count: Int) {
        if (index == requests.size) {
            for (i in 0 until n) {
                if (buildings[i] != 0) {
                    return
                }
            }
            answer = answer.coerceAtLeast(count)
            return
        }


        buildings[requests[index][0]]--
        buildings[requests[index][1]]++
        // 이동 시키기
        backtracking(requests, buildings, n, index + 1, count + 1)


        buildings[requests[index][0]]++
        buildings[requests[index][1]]--
        // 이동 안하고 다음 빌딩 보기
        backtracking(requests, buildings, n, index + 1, count)
    }
}