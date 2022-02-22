package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
        int[] ints1 = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(ints1));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] result = new int[nums.length];

        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }
}
