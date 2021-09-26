package problems;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        boolean even = (n1 + n2) % 2 == 0;

        if (n1 == 0 || n2 == 0) {
            int mid = (n1 + n2) / 2;
            if (even) {
                return (getVal(nums1, nums2, mid) + getVal(nums1, nums2, mid + 1)) / 2;
            } else {
                return getVal(nums1, nums2, mid + 1);
            }
        }

        if (nums1[n1 - 1] < nums2[0]) {
            int mid = (n1 + n2) / 2;
            if (even) {
                return (getVal(nums1, nums2, mid) + getVal(nums1, nums2, mid + 1)) / 2;
            } else {
                return getVal(nums1, nums2, mid + 1);
            }
        }

        if (nums2[n2 - 1] < nums1[0]) {
            int mid = (n1 + n2) / 2;
            if (even) {
                return (getVal(nums2, nums1, mid) + getVal(nums2, nums1, mid + 1)) / 2;
            } else {
                return getVal(nums2, nums1, mid + 1);
            }
        }


        // 값이 겹치면 문제가 되는데

        // TODO 푸는중....


        return 0.0;
    }

    private double getVal(int[] nums1, int[] nums2, int pos) {
        int n1 = nums1.length;

        if (n1 >= pos) {
            return nums1[pos - 1];
        }

        pos -= n1;

        return nums2[pos - 1];
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();

        System.out.println(m.findMedianSortedArrays(new int[]{1,2,3,4,5,6,7,8}, new int[]{}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,2,3,4,5,6,7}, new int[]{}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1,2,3,4,5,6,7}));

        System.out.println(m.findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5,6,7,8}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5,6,7,8}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,2,3,4,5}, new int[]{6,7,8}));

        System.out.println(m.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4,5}));
        System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5}));

        System.out.println(m.findMedianSortedArrays(new int[]{5,6,7,8}, new int[]{1,2,3,4}));
        System.out.println(m.findMedianSortedArrays(new int[]{4,5,6,7,8}, new int[]{1,2,3}));
        System.out.println(m.findMedianSortedArrays(new int[]{6,7,8}, new int[]{1,2,3,4,5}));

        System.out.println(m.findMedianSortedArrays(new int[]{2,3,4,5}, new int[]{1}));
        System.out.println(m.findMedianSortedArrays(new int[]{3,4,5}, new int[]{1,2}));
        System.out.println(m.findMedianSortedArrays(new int[]{4,5}, new int[]{1,2,3}));
    }

}

/*
 // array 합치고, sort 하고 중간 찾기 -> O(Nlogn) -> X
 // O(log (n+m)) 안에 끝내야함. -> binary search 를 생각해야함.

 [1, 2, 3, 4]
             [5, 6, 7, 8]
 n1 + n2 is odd -> ((n1 + n2) /2 + (n1 + n2) / 2 + 1) / 2
 n1 + n2 is even -> (n1 + n2) / 2


 [1, 2, 3, 4]
       [1, 2, 7, 8]
 [1, 1, 2, 2, 3, 4, 7, 8] => 2 + 3 / 2
 num1[0] diff num2[0]
 num1[max] diff num2[max]
 3번 안에 찾아야함?

 1 / 8
 2 / 7
 3 / 2
 4 / 1

 L : [1, 2, 3, 4] R: [1, 2, 7, 8]
 mid(L(0, 4)) = 2
 mid(R(0, 4)) = 2

 mid(L(2, 4)) = 3
 mid(R(0, 2)) = 1




 */