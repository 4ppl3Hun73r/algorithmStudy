/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {

    const res = [];
    nums = nums.sort((a, b) => a - b);

    // subSet(1,2,3,4) => [1, subSet(2,3,4)]
    // subSet(2,3,4) => [2, subSet(3,4)]
    // subSet(3,4) => [3, subSet(4)]
    // subSet(4) => [4, subSet()]
    // subSet() => []
    const subSet = (len, index, arr) => {
        if (arr.length === len) {
            res.push(arr.slice());
            return ;
        }

        for (let i = index; i < nums.length; i++) {
            if (i !== index && nums[i - 1] === nums[i]) {
                continue;
            }
            arr.push(nums[i]);
            subSet(len, i + 1, arr);
            arr.pop();
        }
    };

    for (let len = 0; len <= nums.length; len++) {
        subSet(len, 0, []);
    }

    return res;
};


/*const checkAndPush = (arr) => {
    const len = arr.length;
    const set2 = new Set(arr);

    let push = true;
    for (let i = 0; i < res.length; i++) {
        if (res[i].length === len) {
            const set1 = new Set(res[i]);
            let eq = true;
            for (const v of set1) {
                if (!set2.has(v)) {
                    eq = false;
                    break;
                }
            }
        }
    }
    if (push) {
        res.push(arr.slice());
    }
}*/