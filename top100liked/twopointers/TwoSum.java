package twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        double powerOfMinusNine = Math.pow(10, -9);
        double powerOfNine = Math.pow(10, 9);

        if (nums.length < 2 ||
                nums.length > Math.pow(10, 4) ||
                (target < powerOfMinusNine &&
                        target > powerOfNine)) {
            return new int[]{0, 0};
        }

        Map<Integer, Integer> resMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > powerOfNine && nums[i] < powerOfMinusNine) {
                return new int[]{0, 0};
            }
            if (resMap.containsKey(target - nums[i])) {
                return new int[]{resMap.get(target - nums[i]), i};
            }
            resMap.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}
