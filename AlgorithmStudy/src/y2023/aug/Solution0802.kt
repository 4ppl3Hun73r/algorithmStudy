package y2023.aug

// https://leetcode.com/problems/permutations/
class Solution0802 {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        recursivePermute(nums, mutableListOf(), result)
        return result
    }

    fun recursivePermute(nums: IntArray, subList: MutableList<Int>, result: MutableList<List<Int>>) {
        if (subList.size == nums.size) {
            result.add(ArrayList(subList))
            return
        }

        for (num in nums) {
            if (!subList.contains(num)) {
                subList.add(num)
                recursivePermute(nums, subList, result)
                subList.removeAt(subList.size - 1)
            }
        }
    }
}

/*
let recursivePermute = (arr) => {
        if (arr.length === 1) return [arr];

        let ret = [];
        for (let i = 0; i < arr.length; i++) {
            let copyArr = arr.slice();

            let s = copyArr.splice(i, 1);
            let sub = recursivePermute(copyArr);
            for (let j = 0; j < sub.length; j++) {
                ret.push(s.concat(sub[j]));
            }
        }
        return ret;
    };

    return recursivePermute(nums);

 */