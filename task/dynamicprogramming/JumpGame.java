package dynamicprogramming;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int lastSuccessIndex = nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastSuccessIndex) {
                lastSuccessIndex = i;
            }
        }

        return lastSuccessIndex == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
