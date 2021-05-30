package twosum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 4, 3, 0};
        Solution solution = new Solution();
        int[] result = solution.twoSum(arr, 0);

        System.out.println(Arrays.toString(result));
    }
}
