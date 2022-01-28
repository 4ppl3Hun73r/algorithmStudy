package y2022.jun;

// https://leetcode.com/problems/valid-mountain-array/
public class Solution0125 {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length - 1;
        int index = 0;
        int walk = 0;
        while(index < len && arr[index] < arr[index + 1]) {
            walk ++;
            index ++;
        }

        if (walk == 0 || index == len) {
            return false;
        }

        while(index < len && arr[index] > arr[index + 1]) {
            walk ++;
            index ++;
        }

        return len == walk;
    }
}
