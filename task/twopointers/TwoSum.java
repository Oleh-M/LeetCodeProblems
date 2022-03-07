package twopointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{0, 0};
        var checkMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var tmp = target - nums[i];
            if (checkMap.containsKey(tmp)) {
                return new int[]{checkMap.get(tmp), i};
            }
            checkMap.put(nums[i], i);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] ints1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints1));
        int[] ints2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints2));
        int[] ints = twoSum(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
