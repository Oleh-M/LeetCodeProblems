package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2)
            return new int[]{0, 0};

        Map<Integer, Integer> resMap = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if(resMap.containsKey(target - numbers[i])) {
                return new int[]{resMap.get(target - numbers[i]) + 1, i + 1};
            }
            resMap.put(numbers[i], i);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        var res1 = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(res1));
    }
}
