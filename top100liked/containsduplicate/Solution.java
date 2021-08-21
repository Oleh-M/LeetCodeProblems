package containsduplicate;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> resultMap = new HashSet<>();

        for (int num : nums) {
            if (resultMap.contains(num)) {
                return true;
            }
            else resultMap.add(num);
        }

        return false;
    }
}
