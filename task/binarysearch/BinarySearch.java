package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12, 16}, 16));
        System.out.println(search(new int[]{2, 5}, 5));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(search(new int[]{-1, 0, 5}, 5));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int mid, left = 0, right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else left = mid + 1;
        }

        return -1;
    }
}
