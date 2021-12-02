package twopointers;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0,
                end = height.length - 1,
                maxSum = 0;
        while (start != end) {
            maxSum = Math.max(Math.min(height[start], height[end]) * (end - start), maxSum);
            if (height[start] < height[end]) start++;
            else end--;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }
}
