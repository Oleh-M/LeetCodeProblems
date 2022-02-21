package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();

        Arrays.sort(nums);
        var resultLists = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) r--;
                else if (nums[i] + nums[l] + nums[r] < 0) l++;
                else {
                    resultLists.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                }
            }
        }

        return resultLists;
    }

    public static void main(String[] args) {
        var res1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res1);
    }
}
