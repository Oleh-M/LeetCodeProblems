package dynamicprogramming;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int currentSum = 0,
                longestSum = nums[0];

        for (int i : nums) {
            if (currentSum < 0) currentSum = 0;
            currentSum += i;
            longestSum = Math.max(longestSum, currentSum);
        }

        return longestSum;
    }
}
