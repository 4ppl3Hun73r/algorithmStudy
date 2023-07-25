package y2023.jul

import java.util.Stack

// https://leetcode.com/problems/asteroid-collision/
class Solution0720 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (asteroid in asteroids) {
            if (asteroid < 0) {
                var dis = false
                while (stack.isNotEmpty() && (stack.peek() > 0 && stack.peek() <= -asteroid)) {
                    val top = stack.pop()
                    if (top == -asteroid) {
                        dis = true
                        break
                    }
                }
                if (!dis && (stack.isEmpty() || stack.peek() < 0)) {
                    stack.push(asteroid)
                }
            } else {
                stack.push(asteroid)
            }
        }

        val result = IntArray(stack.size)
        var idx = 0
        for ( v in stack.reversed()) {
            result[idx++] = v
        }
        return result
    }
}

/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */