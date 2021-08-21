package missingnumber;

/*
Given an array nums containing n distinct numbers in the range [0, n],
 return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity
 and O(n) runtime complexity?
 */

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber(new int[]{0}));
    }

    public static int missingNumber(int[] nums) {
        Set<Integer> values = new HashSet<>(nums.length);
        for (int num : nums) {
            values.add(num);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!values.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
