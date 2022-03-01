package dynamicprogramming;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = 1, currMin = 1;

        for (int n : nums) {
            if (n == 0) {
                currMax = 1;
                currMin = 1;
            }
            int tmp = currMax * n;
            currMax = Math.max(tmp, Math.max(currMin * n, n));
            currMin = Math.min(tmp, Math.min(currMin * n, n));

            max = Math.max(max, Math.max(currMax, currMin));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{3, -1, 4}));
        System.out.println(maxProduct(new int[]{-3, -1, -1}));
    }
}
