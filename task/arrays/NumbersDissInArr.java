package arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersDissInArr {
    public static void main(String[] args) {

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numsSet = new HashSet<>(nums.length);
        Set<Integer> numbersIndexSet = new HashSet<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
            numbersIndexSet.add(i + 1);
        }

        numbersIndexSet.removeAll(numsSet);

        return new ArrayList<>(numbersIndexSet);
    }

    public static List<Integer> findDisappearedNumbers2 (int[] nums) {
        List<Integer> missingNums = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>(nums.length);

        for (int num : nums) {
            numbers.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if(!numbers.contains(i)) {
                missingNums.add(i);
            }
        }

        return missingNums;
    }
}
