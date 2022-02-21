package twopointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        var result = new HashMap<Integer, Integer>(2);

        for (int i = 0; i < nums.length; i++) {
            var intermediary = target - nums[i];
            if (result.containsKey(intermediary)) {
                return new int[]{result.get(intermediary), i};
            }
            result.put(nums[i], i);
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
