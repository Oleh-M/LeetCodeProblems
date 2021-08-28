package medianoftwoarr;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000

Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000

Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000



Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106


*/
class Solution {
    public static void main(String[] args) {
        findMedianSortedArrays(new int[] {1, 2, 3, 4, 5}, new int[] {7,8,9,0,-1});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0;

        Queue<Integer> pq = new PriorityQueue<>(nums1.length + nums2.length);

        for (int i : nums1) {
            pq.add(i);
        }

        for (int i : nums2) {
            pq.add(i);
        }

        int size = pq.size();
        int mid = size % 2 == 0 ? (size / 2) - 1 : size / 2;

        for (int i = 0; i < mid; i++) {
            pq.poll();
        }

        double res = pq.poll();
        if (size % 2 == 0) {
            res += pq.poll();
            res /= 2;
        }
        return res;
    }
}
