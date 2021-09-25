package arrays;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Set<Integer> result = new HashSet<>();

        for (int num : nums) {
            if(!result.contains(num)) {
                result.add(num);
            } else result.remove(num);
        }

        return result.iterator().next();
    }
}
