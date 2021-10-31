package dynamicprogramming;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int longestSum = nums[0];
        int currentSum = 0;

        for (int n : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += n;
            longestSum = Math.max(longestSum, currentSum);
        }

        return longestSum;
    }
}
