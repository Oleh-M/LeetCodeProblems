package arrays;

public class MinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0,
                right = nums.length - 1,
                min = nums[0];

        while (left != right) {
            min = Math.min(nums[left], nums[right]);

            if (nums[left] > nums[right]) {
                left++;
            } else right--;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
    }
}
