package binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 5, 6, 1, 2}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{}, 123));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 123));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0,
                right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else right = mid;
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        if (nums[start] <= target && nums[right] >= target)
            left = start;
        else right = start;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else return mid;
        }

        return -1;
    }
}
