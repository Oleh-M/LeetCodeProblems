package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

     Notice that the solution set must not contain duplicate triplets.
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return List.of();
        Arrays.sort(nums);
        var res = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1,
                        high = nums.length - 1,
                        sum = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(List.of(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else low++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{1, -1, -1, 0});
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
