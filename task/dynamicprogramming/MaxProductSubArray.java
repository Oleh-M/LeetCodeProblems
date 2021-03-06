package dynamicprogramming;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxProduct = nums[0],
                currentMax = 1,
                currentMin = 1;

        for (int i : nums) {
            if (i == 0) {
                currentMax = 1;
                currentMin = 1;
            }
            var tmp = currentMax * i;
            currentMax = Math.max(tmp, Math.max(currentMin * i, i));
            currentMin = Math.min(tmp, Math.min(currentMin * i, i));

            maxProduct = Math.max(maxProduct, Math.max(currentMax, currentMin));
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{3, -1, 4}));
        System.out.println(maxProduct(new int[]{-3, -1, -1}));
    }
}
